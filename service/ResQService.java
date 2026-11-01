package service;

import model.Emergency;
import model.Resource;

import java.util.*;

public class ResQService {
    private Set<Resource> available;
    private Map<String, Resource> allResources;
    private List<String> history;
    private DispatchQueue queue;

    // Map to track which resource is assigned to which emergency
    private Map<String, Emergency> assignedResources;


    public ResQService() {
        this.available = new HashSet<>();
        this.allResources = new HashMap<>();
        this.history = new ArrayList<>();
        this.queue = new DispatchQueue();
        this.assignedResources = new HashMap<>();
    }


    public void addResource(Resource res) {
        if (allResources.containsKey(res.getResourceId())) {
            System.out.println(" Duplicate Resource ID!");
            return;
        }
        allResources.put(res.getResourceId(), res);
        available.add(res);
        System.out.println("Resource Added: " + res);
    }


    public void reportEmergency(Emergency e) {
        queue.add(e);
        System.out.println("Reported: " + e);
    }


    public void processNext() {
        if (queue.isEmpty()) {
            System.out.println(" No pending emergencies.");
            return;
        }

        List<Emergency> tempList = new ArrayList<>();
        boolean dispatchedAny = false;

        while (!queue.isEmpty()) {
            Emergency current = queue.dispatchNext();
            
            if (dispatchedAny) {
                tempList.add(current);
                continue;
            }

            // Match resource
            Resource assigned = null;
            for (Resource r : available) {
                if (r.getType() == current.getType()) {
                    assigned = r;
                    break;
                }
            }

            if (assigned != null) {
                assigned.setAvailable(false);
                available.remove(assigned);
                current.setStatus("DISPATCHED");
                
                assignedResources.put(assigned.getResourceId(), current);
                
                String log = "Dispatched " + assigned + " to " + current.getLocation() + " for " + current.getId();
                history.add(log);
                System.out.println("🚑" + log);
                
                dispatchedAny = true;
            } else {
                tempList.add(current);
            }
        }

        if (!dispatchedAny) {
            System.out.println("No matching resources available for any pending emergency.");
        }

        // Re-add unprocessed emergencies back to the queue
        for (Emergency e : tempList) {
            queue.add(e);
        }
    }


    public void resolveResource(String id) {
        String normalizedId = id == null ? "" : id.trim();
        Resource r = allResources.get(normalizedId);
        
        if (r == null || r.isAvailable()) {
            System.out.println("Invalid or already available.");
            return;
        }

        Emergency e = assignedResources.get(id);
        if (e != null) {
            e.setStatus("RESOLVED");
            assignedResources.remove(id);
            System.out.println("Emergency " + e.getId() + " is now RESOLVED.");
        }

        r.setAvailable(true);
        available.add(r);
        System.out.println("Resource " + id + " is available now.");
    }


    public void showPending() {
        queue.showPending();
    }


    public void showHistory() {
        System.out.println("\n--- History ---");
        if (history.isEmpty()) System.out.println("No history.");
        for (String h : history) {
            System.out.println(h);
        }
    }
}