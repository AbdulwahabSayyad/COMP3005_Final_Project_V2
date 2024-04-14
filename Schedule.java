import java.time.LocalTime;

public class Schedule {
    private int scheduleId;
    private LocalTime monStart;
    private LocalTime monEnd;
    private LocalTime tueStart;
    private LocalTime tueEnd;
    private LocalTime wedStart;
    private LocalTime wedEnd;
    private LocalTime thuStart;
    private LocalTime thuEnd;
    private LocalTime friStart;
    private LocalTime friEnd;
    private LocalTime satStart;
    private LocalTime satEnd;
    private LocalTime sunStart;
    private LocalTime sunEnd;

    // Getters
    public int getScheduleId() {
        return scheduleId;
    }

    public LocalTime getMonStart() {
        return monStart;
    }

    public LocalTime getMonEnd() {
        return monEnd;
    }

    public LocalTime getTueStart() {
        return tueStart;
    }

    public LocalTime getTueEnd() {
        return tueEnd;
    }

    public LocalTime getWedStart() {
        return wedStart;
    }

    public LocalTime getWedEnd() {
        return wedEnd;
    }

    public LocalTime getThuStart() {
        return thuStart;
    }

    public LocalTime getThuEnd() {
        return thuEnd;
    }

    public LocalTime getFriStart() {
        return friStart;
    }

    public LocalTime getFriEnd() {
        return friEnd;
    }

    public LocalTime getSatStart() {
        return satStart;
    }

    public LocalTime getSatEnd() {
        return satEnd;
    }

    public LocalTime getSunStart() {
        return sunStart;
    }

    public LocalTime getSunEnd() {
        return sunEnd;
    }

    // Setters
    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setMonStart(LocalTime monStart) {
        this.monStart = monStart;
    }

    public void setMonEnd(LocalTime monEnd) {
        this.monEnd = monEnd;
    }

    public void setTueStart(LocalTime tueStart) {
        this.tueStart = tueStart;
    }

    public void setTueEnd(LocalTime tueEnd) {
        this.tueEnd = tueEnd;
    }

    public void setWedStart(LocalTime wedStart) {
        this.wedStart = wedStart;
    }

    public void setWedEnd(LocalTime wedEnd) {
        this.wedEnd = wedEnd;
    }

    public void setThuStart(LocalTime thuStart) {
        this.thuStart = thuStart;
    }

    public void setThuEnd(LocalTime thuEnd) {
        this.thuEnd = thuEnd;
    }

    public void setFriStart(LocalTime friStart) {
        this.friStart = friStart;
    }

    public void setFriEnd(LocalTime friEnd) {
        this.friEnd = friEnd;
    }

    public void setSatStart(LocalTime satStart) {
        this.satStart = satStart;
    }

    public void setSatEnd(LocalTime satEnd) {
        this.satEnd = satEnd;
    }

    public void setSunStart(LocalTime sunStart) {
        this.sunStart = sunStart;
    }

    public void setSunEnd(LocalTime sunEnd) {
        this.sunEnd = sunEnd;
    }
}

