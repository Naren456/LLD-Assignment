package elevator.panel;

import elevator.buttons.UpButton;
import elevator.buttons.DownButton;
import elevator.model.Display;

public class FloorPanel implements elevator.model.ElevatorObserver {
    private final int floorNumber;
    private final Display display;
    private final UpButton upButton;
    private final DownButton downButton;

    public FloorPanel(int floorNumber) {
        this.floorNumber = floorNumber;
        this.display = new Display();
        this.upButton = new UpButton(floorNumber);
        this.downButton = new DownButton(floorNumber);
    }

    @Override
    public void onStateUpdate(int floor, elevator.enums.Direction dir) {
        display.update(floor, dir);
    }

    public UpButton getUpButton() {
        return upButton;
    }

    public DownButton getDownButton() {
        return downButton;
    }

    public Display getDisplay() {
        return display;
    }
}
