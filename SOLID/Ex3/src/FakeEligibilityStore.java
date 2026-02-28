public class FakeEligibilityStore implements Store{
    public void save(String roll, String status) {
        System.out.println("Saved evaluation for roll=" + roll);
    }
}
