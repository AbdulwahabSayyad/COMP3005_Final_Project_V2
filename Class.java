import java.sql.Timestamp;

public class Class {
    private int classId;
    private String className;
    private int scheduleId;
    private int currentMembers;
    private int maxMembers;
    private double price;
    private String notes;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters
    public int getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public int getCurrentMembers() {
        return currentMembers;
    }

    public int getMaxMembers() {
        return maxMembers;
    }

    public double getPrice() {
        return price;
    }

    public String getNotes() {
        return notes;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    // Setters
    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setCurrentMembers(int currentMembers) {
        this.currentMembers = currentMembers;
    }

    public void setMaxMembers(int maxMembers) {
        this.maxMembers = maxMembers;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}

