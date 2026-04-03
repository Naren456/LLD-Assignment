package elevator.model;

import elevator.enums.Direction;

public interface ElevatorObserver {
    void onStateUpdate(int floor, Direction direction);
}
