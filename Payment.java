import java.sql.Timestamp;
import java.util.Date;

public class Payment {
    private int paymentId;
    private int memberId;
    private double total;
    private String paymentMethod;
    private Date paymentDate;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters
    public int getPaymentId() {
        return paymentId;
    }

    public int getMemberId() {
        return memberId;
    }

    public double getTotal() {
        return total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    // Setters
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}

