import java.sql.Timestamp;

public class Exercise {
    private int exerciseId;
    private int memberId;
    private String exerciseName;
    private String exerciseType;
    private Integer exerciseSets; // This can be null
    private Integer exerciseReps; // This can be null
    private Integer prCurrent; // This can be null
    private Integer prGoal; // This can be null
    private Integer distance; // This can be null
    private Integer timeCurrent; // This can be null
    private Integer timeGoal; // This can be null
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters
    public int getExerciseId() {
        return exerciseId;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public Integer getExerciseSets() {
        return exerciseSets;
    }

    public Integer getExerciseReps() {
        return exerciseReps;
    }

    public Integer getPrCurrent() {
        return prCurrent;
    }

    public Integer getPrGoal() {
        return prGoal;
    }

    public Integer getDistance() {
        return distance;
    }

    public Integer getTimeCurrent() {
        return timeCurrent;
    }

    public Integer getTimeGoal() {
        return timeGoal;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    // Setters
    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public void setExerciseSets(Integer exerciseSets) {
        this.exerciseSets = exerciseSets;
    }

    public void setExerciseReps(Integer exerciseReps) {
        this.exerciseReps = exerciseReps;
    }

    public void setPrCurrent(Integer prCurrent) {
        this.prCurrent = prCurrent;
    }

    public void setPrGoal(Integer prGoal) {
        this.prGoal = prGoal;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public void setTimeCurrent(Integer timeCurrent) {
        this.timeCurrent = timeCurrent;
    }

    public void setTimeGoal(Integer timeGoal) {
        this.timeGoal = timeGoal;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
