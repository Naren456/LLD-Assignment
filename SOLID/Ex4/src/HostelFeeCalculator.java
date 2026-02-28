import java.util.*;

public class HostelFeeCalculator {
    private final Saveable saveable;

    public HostelFeeCalculator(Saveable saveable) {
        this.saveable = saveable;
    }

    // OCP violation: switch + add-on branching + printing + persistence.
    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        saveable.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        Money base = null;
        List<RoomChoice> list = new ArrayList<>();
        SingleRoomChoice singleRoomChoice = new SingleRoomChoice();
        DoubleRoomChoice doubleRoomChoice = new DoubleRoomChoice();
        TripleRoomChoice tripleRoomChoice = new TripleRoomChoice();
        list.add(singleRoomChoice);
        list.add(doubleRoomChoice);
        list.add(tripleRoomChoice);
        for (RoomChoice rc : list) {
            if (rc.isSameType(req.roomType)) {
                base = rc.getBase();
                break;
            }
        }

        if (base == null) {
            base = new Money(16000.0);
        }

        Money add = new Money(0.0);
        List<AddOnChoice> addOnChoices = new ArrayList<>();
        MessAddOn messAddOn = new MessAddOn();
        LaundryAddOn laundryAddOn = new LaundryAddOn();
        GymAddOn gymAddOn = new GymAddOn();
        addOnChoices.add(messAddOn);
        addOnChoices.add(laundryAddOn);
        addOnChoices.add(gymAddOn);
        for (AddOn a : req.addOns) {
            for (AddOnChoice aoc : addOnChoices) {
                if (aoc.isSameAddOn(a))
                    add.plus(aoc.getAddOnPrice());
            }
        }

        return base.plus(add);
    }
}
