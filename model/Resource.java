package model;

public class Resource {
    private String resourceId;
    private EmergencyType type;
    private boolean isAvailable;


    public Resource(String resourceId, EmergencyType type) {
        this.resourceId = resourceId;
        this.type = type;
        this.isAvailable = true;
    }


    public String getResourceId(){ return resourceId; }
    public EmergencyType getType(){ return type; }
    public boolean isAvailable(){ return isAvailable; }
    public void setAvailable(boolean available){ this.isAvailable = available; }
   

    @Override
    public String toString() {
        return "Resource{" +
                "resourceId='" + resourceId + '\'' +
                ", type=" + type +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
