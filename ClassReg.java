import java.sql.Timestamp;

public class ClassReg {
    private int regId;
    private int memberId;
    private int classId;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters
    public int getRegId() {
        return regId;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getClassId() {
        return classId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    // Setters
    public void setRegId(int regId) {
        this.regId = regId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}

