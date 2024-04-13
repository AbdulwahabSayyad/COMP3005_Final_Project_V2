import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;
import java.sql.Date;

public class Member {
    private int memberId;
    private String firstName;
    private String lastName;
    private Date dob;
    private String gender;
    private String email;
    private double weightCurrent;
    private double weightGoal;
    private double bodyFatCurrent;
    private double bodyFatGoal;
    private int caloriesBase;
    private int caloriesGoal;
    private Date dateGoal;
    private String achievements;
    private String notes;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters
    public int getMemberId() {
        return memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public double getWeightCurrent() {
        return weightCurrent;
    }

    public double getWeightGoal() {
        return weightGoal;
    }

    public double getBodyFatCurrent() {
        return bodyFatCurrent;
    }

    public double getBodyFatGoal() {
        return bodyFatGoal;
    }

    public int getCaloriesBase() {
        return caloriesBase;
    }

    public int getCaloriesGoal() {
        return caloriesGoal;
    }

    public Date getDateGoal() {
        return dateGoal;
    }

    public String getAchievements() {
        return achievements;
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
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(Date l) {
        this.dob = l;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWeightCurrent(double weightCurrent) {
        this.weightCurrent = weightCurrent;
    }

    public void setWeightGoal(double weightGoal) {
        this.weightGoal = weightGoal;
    }

    public void setBodyFatCurrent(double bodyFatCurrent) {
        this.bodyFatCurrent = bodyFatCurrent;
    }

    public void setBodyFatGoal(double bodyFatGoal) {
        this.bodyFatGoal = bodyFatGoal;
    }

    public void setCaloriesBase(int caloriesBase) {
        this.caloriesBase = caloriesBase;
    }

    public void setCaloriesGoal(int caloriesGoal) {
        this.caloriesGoal = caloriesGoal;
    }

    public void setDateGoal(Date dateGoal) {
        this.dateGoal = dateGoal;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
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

    public String generateAchievements() {
        double weightDifference = Math.abs(weightGoal - weightCurrent);
        double bodyFatDifference = Math.abs(bodyFatGoal - bodyFatCurrent);
        int caloriesDifference = Math.abs(caloriesGoal - caloriesBase);

        long millis = System.currentTimeMillis();
        Date currentDate = new Date(millis);
        long diffInMillies = Math.abs(dateGoal.getTime() - currentDate.getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        String achievementsMessage = "ACHIEVEMENTS:\nYou are " + weightDifference + " kg away from your weight goal, " 
            + bodyFatDifference + "% away from your body fat goal, and " 
            + caloriesDifference + " calories away from your calorie goal. "
            + "You have " + diffInDays + " days left until your target date!";
    
        return achievementsMessage;
    }
    
}

