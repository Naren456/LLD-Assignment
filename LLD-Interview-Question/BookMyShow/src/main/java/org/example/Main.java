package org.example;

import org.example.model.*;
import org.example.service.*;
import org.example.strategy.DefaultPricingStrategy;
import org.example.strategy.PricingStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize Services
        MovieService movieService = new MovieService();
        TheatreService theatreService = new TheatreService();
        PaymentService paymentService = new PaymentService();
        BookingService bookingService = new BookingService(paymentService);
        PricingStrategy pricingStrategy = new DefaultPricingStrategy();

        // 2. Setup Data
        City bangalore = new City("BLR", "Bangalore");
        Movie movie = new Movie("M1", "Inception", 148, "English");
        movieService.addMovie(movie, bangalore.getId());

        Theatre theatre = new Theatre("T1", "PVR Koramangala", bangalore.getId());
        Screen screen = new Screen("S1", "Screen 1");
        
        // Add seats to screen
        for (int i = 0; i < 5; i++) {
            screen.addSeat(new Seat("Seat-" + i, 1, i, SeatCategory.GOLD));
        }
        theatre.addScreen(screen);
        theatreService.addTheatre(theatre);

        // 3. Create a Show
        Show show = new Show("SH1", movie, screen, LocalDateTime.now().plusHours(2), 150);
        theatreService.addShow(show);

        // 4. Initialize ShowSeats
        List<ShowSeat> showSeats = new ArrayList<>();
        for (Seat seat : screen.getSeats()) {
            double price = pricingStrategy.calculatePrice(show, seat.getSeatCategory());
            showSeats.add(new ShowSeat(show.getId() + "-" + seat.getId(), show, seat, price));
        }
        bookingService.addShowSeats(show.getId(), showSeats);

        // 5. User Interaction
        User user = new User("U1", "John Doe", "john@example.com");
        
        System.out.println("Available movies in Bangalore: " + movieService.getMoviesByCity("BLR").get(0).getTitle());
        
        System.out.println("Available seats for show: ");
        bookingService.getAvailableSeats(show.getId()).forEach(s -> System.out.print(s.getSeat().getId() + " "));
        System.out.println();

        // 6. Book Tickets
        try {
            List<String> seatsToBook = Arrays.asList("SH1-Seat-0", "SH1-Seat-1");
            Booking booking = bookingService.createBooking(user, show, seatsToBook);
            System.out.println("Booking successful! ID: " + booking.getId() + " Total: " + booking.getTotalAmount());
        } catch (Exception e) {
            System.err.println("Booking failed: " + e.getMessage());
        }

        // 7. Verify availability
        System.out.println("Updated available seats: ");
        bookingService.getAvailableSeats(show.getId()).forEach(s -> System.out.print(s.getSeat().getId() + " "));
        System.out.println();
    }
}
