import java.sql.Timestamp;
import java.util.Date;

public class Schedule {
    private int scheduleId;
    private Date monStart;
    private Date monEnd;
    private Date tueStart;
    private Date tueEnd;
    private Date wedStart;
    private Date wedEnd;
    private Date thuStart;
    private Date thuEnd;
    private Date friStart;
    private Date friEnd;
    private Date satStart;
    private Date satEnd;
    private Date sunStart;
    private Date sunEnd;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters
    public int getScheduleId() {
        return scheduleId;
    }

    public Date getMonStart() {
        return monStart;
    }

    public Date getMonEnd() {
        return monEnd;
    }

    public Date getTueStart() {
        return tueStart;
    }

    public Date getTueEnd() {
        return tueEnd;
    }

    public Date getWedStart() {
        return wedStart;
    }

    public Date getWedEnd() {
        return wedEnd;
    }

    public Date getThuStart() {
        return thuStart;
    }

    public Date getThuEnd() {
        return thuEnd;
    }

    public Date getFriStart() {
        return friStart;
    }

    public Date getFriEnd() {
        return friEnd;
    }

    public Date getSatStart() {
        return satStart;
    }

    public Date getSatEnd() {
        return satEnd;
    }

    public Date getSunStart() {
        return sunStart;
    }

    public Date getSunEnd() {
        return sunEnd;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    // Setters
    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setMonStart(Date monStart) {
        this.monStart = monStart;
    }

    public void setMonEnd(Date monEnd) {
        this.monEnd = monEnd;
    }

    public void setTueStart(Date tueStart) {
        this.tueStart = tueStart;
    }

    public void setTueEnd(Date tueEnd) {
        this.tueEnd = tueEnd;
    }

    public void setWedStart(Date wedStart) {
        this.wedStart = wedStart;
    }

    public void setWedEnd(Date wedEnd) {
        this.wedEnd = wedEnd;
    }

    public void setThuStart(Date thuStart) {
        this.thuStart = thuStart;
    }

    public void setThuEnd(Date thuEnd) {
        this.thuEnd = thuEnd;
    }

    public void setFriStart(Date friStart) {
        this.friStart = friStart;
    }

    public void setFriEnd(Date friEnd) {
        this.friEnd = friEnd;
    }

    public void setSatStart(Date satStart) {
        this.satStart = satStart;
    }

    public void setSatEnd(Date satEnd) {
        this.satEnd = satEnd;
    }

    public void setSunStart(Date sunStart) {
        this.sunStart = sunStart;
    }

    public void setSunEnd(Date sunEnd) {
        this.sunEnd = sunEnd;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}

