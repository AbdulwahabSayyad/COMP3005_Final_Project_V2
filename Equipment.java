import java.sql.Timestamp;
import java.util.Date;

public class Equipment {
    private int equipmentId;
    private String equipmentName;
    private boolean isFunctioning;
    private Date maintenanceLast;
    private Date maintenanceNext;
    private Integer assignedStaff; // This can be null
    private String notes;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters
    public int getEquipmentId() {
        return equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public boolean isFunctioning() {
        return isFunctioning;
    }

    public Date getMaintenanceLast() {
        return maintenanceLast;
    }

    public Date getMaintenanceNext() {
        return maintenanceNext;
    }

    public Integer getAssignedStaff() {
        return assignedStaff;
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
    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public void setFunctioning(boolean functioning) {
        isFunctioning = functioning;
    }

    public void setMaintenanceLast(Date maintenanceLast) {
        this.maintenanceLast = maintenanceLast;
    }

    public void setMaintenanceNext(Date maintenanceNext) {
        this.maintenanceNext = maintenanceNext;
    }

    public void setAssignedStaff(Integer assignedStaff) {
        this.assignedStaff = assignedStaff;
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

