public class AttendanceViolation implements Violation{
    private StudentProfile s;

    public AttendanceViolation(StudentProfile s) {
        this.s = s;
    }

    public boolean isViolation(){
        return s.attendancePct < 75;
    }

    public String getFailureReason(){
        return "attendance below 75";
    }
}
