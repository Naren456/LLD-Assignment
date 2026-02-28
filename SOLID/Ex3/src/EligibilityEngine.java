import java.util.*;

public class EligibilityEngine {
    private final Store store;

    public EligibilityEngine(Store store) { this.store = store; }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s); // giant conditional inside
        p.print(s, r);
       store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();
        AttendanceViolation av = new AttendanceViolation(s);
        CgrViolation cgv = new CgrViolation(s);
        CreditsViolation crv = new CreditsViolation(s);
        DisciplinaryViolation dv = new DisciplinaryViolation(s);

        List<Violation> list = new ArrayList<>();
        list.add(dv);
        list.add(cgv);
        list.add(av);
        list.add(crv);

        String status = "ELIGIBLE";
        for(Violation v : list){
            if(v.isViolation()){
                reasons.add(v.getFailureReason());
                status = "NOT_ELIGIBLE";
                break;
            }
        }

        return new EligibilityEngineResult(status, reasons);
    }
}

