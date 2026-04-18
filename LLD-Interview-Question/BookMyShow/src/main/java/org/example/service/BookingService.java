package org.example.service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.example.model.*;

public class BookingService {
    private final PaymentService paymentService;
    private final Map<String, List<ShowSeat>> showSeatsMap = new ConcurrentHashMap<>();
    private final Map<String, Booking> bookings = new ConcurrentHashMap<>();

    public BookingService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void addShowSeats(String showId, List<ShowSeat> seats) {
        showSeatsMap.put(showId, seats);
    }

    public List<ShowSeat> getAvailableSeats(String showId) {
        return showSeatsMap.getOrDefault(showId, Collections.emptyList())
                .stream()
                .filter(s -> s.getSeatStatus() == SeatStatus.AVAILABLE)
                .collect(Collectors.toList());
    }

    public Booking createBooking(User user, Show show, List<String> seatIds) {
        List<ShowSeat> allSeats = showSeatsMap.get(show.getId());
        List<ShowSeat> selectedSeats = allSeats.stream()
                .filter(s -> seatIds.contains(s.getId()))
                .collect(Collectors.toList());

        // Attempt to lock all seats
        for (ShowSeat seat : selectedSeats) {
            if (!seat.lock()) {
                // Release previously locked seats if any fail
                selectedSeats.forEach(ShowSeat::release);
                throw new RuntimeException("One or more seats are already locked or booked");
            }
        }

        Booking booking = new Booking(UUID.randomUUID().toString(), user, show, selectedSeats);
        bookings.put(booking.getId(), booking);

        // Process Payment
        PaymentStatus paymentStatus = paymentService.processPayment(booking.getId(), booking.getTotalAmount());

        if (paymentStatus == PaymentStatus.SUCCESS) {
            booking.confirm();
        } else {
            booking.cancel();
            throw new RuntimeException("Payment failed, seats released");
        }

        return booking;
    }
}
