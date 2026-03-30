## Requirements :

1. Functional Requirements (Core Use Cases)
User Operations
User should be able to:
View movies in a city
View theaters in a city
View shows for a movie or theater
View seat map for a show
Select and lock seats
Book tickets
Make payment
Cancel booking and get refund

Admin Operations
Admin should be able to:
Add/update movies
Add/update theaters
Add screens in a theater
Add shows for a screen
Configure pricing rules

2. Core System Requirements
System should support:
Multiple cities
Multiple theaters per city
Multiple screens per theater
Multiple shows per screen
Each show should:
Have a fixed seat layout
Maintain seat availability

3. Booking Flow Requirements
User selects:
City → Movie/Theater → Show
System shows:
Seat map with availability
User selects seats:
Seats should be temporarily locked
User proceeds to payment:
On success → booking confirmed
On failure → seats released

4. Seat Locking & Concurrency
When a user selects seats:
Seats must be locked for a fixed duration (e.g., 5 minutes)
System must ensure:
No two users can book the same seat
Handle concurrency using:
Optimistic locking OR
Pessimistic locking

5. Pricing Requirements
Each seat has:
Category (Silver, Gold, Platinum)
Base price
Final price should support:
Show-based pricing
Day/time-based pricing
Demand-based surge pricing

6. Payment Requirements
System should:
Integrate with external payment gateway
Support multiple payment methods
Payment states:
INITIATED
SUCCESS
FAILED

7. Cancellation & Refund
User can cancel booking:
Before show time
System should:
Update booking status
Trigger refund

8. Data Consistency Requirements
System must ensure:
No double booking
Seat state is always consistent
Booking should be:
Atomic (all seats booked or none)

9. Non-Functional (LLD-Relevant)
Low latency for:
Seat selection
Booking
High concurrency support
Thread-safe operations




10. Out of Scope (Explicit in Interview)
Coupons / discounts
Real-time seat updates across users
Recommendation system



