# Requirements: Multi-Elevator System (LLD)

This document specifies the functional and non-functional requirements for the Multi-Elevator Low-Level Design (LLD).

## 1. Functional Requirements (FR)

| ID | Requirement | Description |
| :--- | :--- | :--- |
| **FR-1** | **Multi-Elevator Support** | The system must manage a fleet of $N$ elevators simultaneously. |
| **FR-2** | **Dispatching Strategy** | Calls from floor-level buttons must be assigned to the most suitable elevator (e.g., Nearest Elevator logic). |
| **FR-3** | **Internal & External Calls** | Support for requests from both outside the elevator (floor panels) and inside the elevator (buttons). |
| **FR-4** | **Safety Monitoring** | Real-time weight validation to prevent overloading. |
| **FR-5** | **Emergency System** | Support for manual emergency alarm triggers to stop/hold elevators. |
| **FR-6** | **Display Synchronization** | Every floor and interior panel must be notified of elevator state changes (floor number, direction) in real-time. |

## 2. Non-Functional Requirements (NFR)

| ID | Requirement | Description |
| :--- | :--- | :--- |
| **NFR-1** | **Modularity** | Hardware components (sensors, doors) should be decoupled from the core logic to allow future upgrades. |
| **NFR-2** | **Scalability** | The design should allow increasing the number of floors and elevators without significant code changes. |
| **NFR-3** | **Simplicity** | Logic should be deterministic and sequential (single-threaded simulation) for easier debugging and validation. |
| **NFR-4** | **Extensibility** | It should be easy to add new dispatching strategies or new sensor types. |
