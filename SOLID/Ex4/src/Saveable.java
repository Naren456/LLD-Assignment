public interface Saveable {
   void save(String id, BookingRequest req, Money monthly, Money deposit);
}