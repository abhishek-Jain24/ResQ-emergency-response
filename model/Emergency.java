package model;
public class Emergency implements Comparable<Emergency> {

    private  String id;
    private String location;
    private Severity severity;
    private EmergencyType type;
    private String  status;
    private int arrivalOrder;        //FIFO Tracking of Emergencies


    public Emergency(String id , String location,Severity serverity, EmergencyType type , int arrivalOrder){
        this.id = id;
        this.location = location;
        this.severity = serverity;
        this.type = type;
        this.status = "Pending";
        this.arrivalOrder = arrivalOrder;
    }


    public String getId() {return id;}
    public String getLocation() {return location;}
    public Severity getSeverity() {return severity;}
    public EmergencyType getType() {return type;}
    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}
    public int getArrivalOrder() {return arrivalOrder;}


    @Override 
    public int compareTo(Emergency other) {
        //Higher based on severity, then by arrival order
        int p = Integer.compare(this.severity.getPriority(), other.severity.getPriority());
        if (p != 0) {
            return p;
        }

        //2. Same Priority, compare by arrival order (FIFO)
        return Integer.compare(this.arrivalOrder, other.arrivalOrder);
    }


    @Override 
    public String toString() {
        return "Emergency{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", severity=" + severity +
                ", type=" + type +
                ", status='" + status + '\'' +
                ", arrivalOrder=" + arrivalOrder +
                '}';
    }
}
