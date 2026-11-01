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

```
=== ResQ MENU ===
1. Report Emergency
2. Dispatch Next
3. Free Resource (Resolves Emergency)
4. View Pending
5. View History
6. Exit
Choose: 1
Location: City Hospital
Severity (1=HIGH, 2=MEDIUM, 3=LOW): 1
Type (1=MEDICAL, 2=FIRE, 3=CRIME): 1
🚨 Reported: [EMG-101] MEDICAL at City Hospital | HIGH | PENDING

=== ResQ MENU ===
Choose: 2
🚑 Dispatched MEDICAL [AMB-01] to City Hospital for EMG-101

=== ResQ MENU ===
Choose: 3
Resource ID to free: AMB-01
✅ Emergency EMG-101 is now RESOLVED.
✅ Resource AMB-01 is available now.
```
