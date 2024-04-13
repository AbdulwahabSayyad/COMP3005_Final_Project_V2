import java.sql.Timestamp;
import java.util.Date;

public class Session {
    private int sessionId;
    private int memberId;
    private int trainerId;
    private Date sessionDate;
    private Date sessionStart;
    private Date sessionEnd;
    private double pricePerSlot;
    private String notes;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters
    public int getSessionId() {
        return sessionId;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public Date getSessionStart() {
        return sessionStart;
    }

    public Date getSessionEnd() {
        return sessionEnd;
    }

    public double getPricePerSlot() {
        return pricePerSlot;
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
    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public void setSessionStart(Date sessionStart) {
        this.sessionStart = sessionStart;
    }

    public void setSessionEnd(Date sessionEnd) {
        this.sessionEnd = sessionEnd;
    }

    public void setPricePerSlot(double pricePerSlot) {
        this.pricePerSlot = pricePerSlot;
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

