package model;

public enum Severity {
    HIGH(1), MEDIUM(2), LOW(3);
    
    private final int priority;
    
    Severity(int priority) { 
        this.priority = priority; 
    }
    
    public int getPriority() { 
        return priority; 
    }
}

