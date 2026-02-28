public class CgrViolation implements Violation{
    private StudentProfile s;

    public CgrViolation(StudentProfile s) {
        this.s = s;
    }

    public boolean isViolation(){
        return s.cgr < 8.0;
    }

    public String getFailureReason(){
        return "CGR below 8.0";
    }
}
