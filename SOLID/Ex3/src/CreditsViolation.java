public class CreditsViolation implements Violation{
    private StudentProfile s;

    public CreditsViolation(StudentProfile s) {
        this.s = s;
    }

    public boolean isViolation(){
        return s.earnedCredits < 20;
    }

    public String getFailureReason(){
        return "credits below 20";
    }
}
