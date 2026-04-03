package elevator.panel;

import elevator.buttons.FloorButton;
import elevator.buttons.DoorOpenButton;
import elevator.buttons.DoorCloseButton;
import elevator.buttons.AlarmButton;
import java.util.ArrayList;
import java.util.List;

import elevator.model.Display;
import elevator.model.ElevatorObserver;

public class InsidePanel implements ElevatorObserver {
    private final List<FloorButton> floorButtons;
    private final DoorOpenButton openButton;
    private final DoorCloseButton closeButton;
    private final AlarmButton alarmButton;
    private final Display display;

    public InsidePanel(int totalFloors) {
        this.floorButtons = new ArrayList<>();
        for (int i = 0; i < totalFloors; i++) {
            floorButtons.add(new FloorButton(i));
        }
        this.openButton = new DoorOpenButton();
        this.closeButton = new DoorCloseButton();
        this.alarmButton = new AlarmButton();
        this.display = new Display();
    }

    @Override
    public void onStateUpdate(int floor, elevator.enums.Direction direction) {
        display.update(floor, direction);
    }

    public List<FloorButton> getFloorButtons() {
        return floorButtons;
    }

    public DoorOpenButton getOpenButton() {
        return openButton;
    }

    public DoorCloseButton getCloseButton() {
        return closeButton;
    }

    public AlarmButton getAlarmButton() {
        return alarmButton;
    }
}
