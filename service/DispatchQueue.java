package service;

import model.Emergency;
import java.util.*;

public class DispatchQueue {
    private Queue<Emergency> queue;

    public DispatchQueue() {
        this.queue = new PriorityQueue<>();
    }

    public void add(Emergency e){
        queue.add(e);
    }

    public Emergency dispatchNext(){
        return queue.poll();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void showPending() {
        System.out.println("\n--- Pending Emergencies ---");
        if (queue.isEmpty()) {
            System.out.println("None");
            return;
        }

        //Copy list to sort and display without modifying the original queue
        ArrayList<Emergency> list = new ArrayList<>(queue);
        Collections.sort(list);

        for(Emergency e : list){
            if(e.getStatus().equals("Pending")) {
                System.out.println(e);
            }
        }
    }

}
