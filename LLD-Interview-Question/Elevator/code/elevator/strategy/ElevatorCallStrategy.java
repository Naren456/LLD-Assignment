package elevator.strategy;

import elevator.model.Elevator;
import elevator.model.Request;
import java.util.List;

public interface ElevatorCallStrategy {
    Elevator selectElevator(Request request, List<Elevator> elevators);
}
