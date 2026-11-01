# 🚨 ResQ - Smart Emergency Response System

A console-based Emergency Response and Resource Allocation System built with Core Java. This project simulates a real-world dispatch center where emergencies are prioritized, and resources are allocated intelligently based on severity and type.

## 🧠 Concepts Covered (Collections Framework)

- **PriorityQueue:** To manage emergencies based on severity and FIFO order.
- **Map (HashMap):** To track all resources and active assignments.
- **Set (HashSet):** To maintain a pool of currently available resources.
- **List (ArrayList):** To store the dispatch history.
- **Comparable:** Custom sorting logic for emergencies.
- **Iterator:** Safe removal of resources from the available set.

## ✨ Features

- **Priority-Based Dispatch:** High-severity emergencies are handled first.
- **FIFO Ordering:** If two emergencies have the same priority, the one reported first gets the resource first.
- **Smart Resource Allocation:** A MEDICAL emergency only gets an Ambulance; a FIRE emergency only gets a Fire Truck.
- **Starvation Prevention:** If a high-priority emergency has no matching resource, the system intelligently handles other emergencies without getting stuck.
- **Status Tracking:** Tracks if an emergency is `PENDING`, `DISPATCHED`, or `RESOLVED`.
- **Crash-Proof Input:** Invalid inputs are handled gracefully without crashing the program.
## 📖 Sample Output

```text
Resource Added: Resource{resourceId='AMB-01', type=MEDICAL, isAvailable=true}
Resource Added: Resource{resourceId='FIRE-01', type=FIRE, isAvailable=true}
Resource Added: Resource{resourceId='POL-01', type=CRIME, isAvailable=true}

=== ResQ MENU ===
1. Report Emergency
2. Dispatch Next
3. Free Resource (Resolves Emergency)
4. View Pending
5. View History
6. Exit
Choose: 1
Location: city hospital
Severity (1=HIGH, 2=MEDIUM, 3=LOW): 1
Type (1=MEDICAL, 2=FIRE, 3=CRIME): 1
Reported: Emergency{id='EMG-101', location='city hospital', severity=HIGH, type=MEDICAL, status='Pending', arrivalOrder=1}

=== ResQ MENU ===
1. Report Emergency
2. Dispatch Next
3. Free Resource (Resolves Emergency)
4. View Pending
5. View History
6. Exit
Choose: 4

--- Pending Emergencies ---
Emergency{id='EMG-101', location='city hospital', severity=HIGH, type=MEDICAL, status='Pending', arrivalOrder=1}

=== ResQ MENU ===
1. Report Emergency
2. Dispatch Next
3. Free Resource (Resolves Emergency)
4. View Pending
5. View History
6. Exit
Choose: 2
?Dispatched Resource{resourceId='AMB-01', type=MEDICAL, isAvailable=false} to city hospital for EMG-101

=== ResQ MENU ===
1. Report Emergency
2. Dispatch Next
3. Free Resource (Resolves Emergency)
4. View Pending
5. View History
6. Exit
Choose: 3
Resource ID to free: AMB-01
Emergency EMG-101 is now RESOLVED.
Resource AMB-01 is available now.

=== ResQ MENU ===
1. Report Emergency
2. Dispatch Next
3. Free Resource (Resolves Emergency)
4. View Pending
5. View History
6. Exit
Choose: 5

--- History ---
Dispatched Resource{resourceId='AMB-01', type=MEDICAL, isAvailable=false} to city hospital for EMG-101

=== ResQ MENU ===
1. Report Emergency
2. Dispatch Next
3. Free Resource (Resolves Emergency)
4. View Pending
5. View History
6. Exit
Choose: 6
 Exiting ResQ...
```
