## Requirements :

Multiple elevator cars in a building
Two types of buttons:
Outside buttons (up and down) on each floor
Inside buttons in each elevator car for floor selection
One set of outside buttons controls all elevators on each floor
Individual button panels inside each elevator car
Optimize elevator selection (e.g., first come first serve, shortest seek time)
Flexible design for easy implementation of new elevator selection algorithms
Elevator states: moving up, moving down, idle, or under maintenance
Weight limit for each elevator (e.g., 700 kg default, configurable)
Emergency alarm functionality
Ability to add new floors after system deployment
Handle elevators under maintenance (non-operational)
Focus on software interfaces and APIs, not physical components
Energy-efficient assignment (only one elevator responds to a call)
Handle concurrency issues (e.g., multiple simultaneous button presses)
Open and close door buttons inside elevators
Ability to stop at floors when moving up or down
All elevator cars can stop on all floors
Handle emergency situations (e.g., power outage)
Support for different weight limits for different elevator cars
Elevator should not move if weight limit is exceeded
Play a sound when weight limit is exceeded
Keep elevator door open when weight limit is exceeded
Support multilingual announcements/interfaces (mentioned briefly)
Handle scenarios where both up and down buttons are pressed simultaneously
Ability to disable specific buttons or floors if needed
Track current floor of each elevator
Handle scenarios where new elevator cars are added to the system
Ensure only one elevator responds to a call, even if multiple are available
Support for express elevators (if mentioned in requirements)
Ability to prioritize certain floors or requests (if part of the requirements)


