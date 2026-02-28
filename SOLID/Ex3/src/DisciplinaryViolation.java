public class DisciplinaryViolation implements Violation{
    private StudentProfile s;

    public DisciplinaryViolation(StudentProfile s) {
        this.s = s;
    }

    public boolean isViolation(){
        return s.disciplinaryFlag != LegacyFlags.NONE;
    }
    public String getFailureReason(){
        return "disciplinary flag present";
    }
}
