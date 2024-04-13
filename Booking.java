import java.sql.Timestamp;

public class Booking {
    private int bookingId;
    private int roomId;
    private Integer classId; // This can be null
    private int scheduleId;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters
    public int getBookingId() {
        return bookingId;
    }

    public int getRoomId() {
        return roomId;
    }

    public Integer getClassId() {
        return classId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    // Setters
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}

