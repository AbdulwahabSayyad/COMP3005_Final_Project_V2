import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Date;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Final Project - V2
 * Abdul Sayyad
 * 101212115
 */

public class FinalProjectV2 {
    public static Connection connection;
    public static final String URL = "jdbc:postgresql://localhost:5432/finalprojectv2";
    public static final String USER = "postgres";
    public static final String PASSWORD = "postgres";

    public static void main(String[] args) {
        boolean appFlag = true;
        int memberID = -1;
        int trainerID = -1;
        int staffID = -1;

        //create the connection
        try {
            String url = URL;
            String username = USER;
            String password = PASSWORD;
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        int userInput = -1;
        System.out.println("Welcome to Abdelghny's Health Club. Please select an option from below:");

        while(appFlag){
            
            System.out.println("1. Member Portal");
            System.out.println("2. Trainer Portal");
            System.out.println("3. Staff Portal");
            System.out.println("4. Exit");

            userInput = scanner.nextInt();

            if(userInput == 1){
                Member member = new Member();
                System.out.println("MEMBER PORTAL AUTHORIZATION:");
                System.out.println("1. Sign In");
                System.out.println("2. Sign Up");
                System.out.println("3. Back");
                userInput = scanner.nextInt();
                if(userInput == 1){
                    member = memberLogin(scanner);
                    memberID = member.getMemberId();
                }
                else if(userInput == 2){
                    member = memberSignUp(scanner);
                    memberID = member.getMemberId();
                }else if(userInput == 3){
                    continue;
                }

                if(memberID == -1 && (userInput == 1 || userInput ==2)){
                    System.out.println("Member ID does not exist. Returning to main menu.");
                    continue;
                }
                else{
                    memberPortal(member, scanner);
                }
            }
            else if (userInput == 2){
                trainerLogin();
            }
            else if (userInput == 3){
                staffLogin();
            }
            else if (userInput == 4){
                System.out.println("Thank you for using the app.");
                appFlag = false;
            }
            else {
                System.out.println("Unkown input. Please try again: \n");
            }
            
        }

        //close connection and scanner
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        scanner.close();
    }

    public static Member memberLogin(Scanner scanner){
        Member member = new Member();
        int memberID = -1;
        System.out.println("Enter your member ID: ");
        memberID = scanner.nextInt();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from members where member_id = ?");
            statement.setInt(1, memberID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Retrieve the member_id from the result set
                memberID = resultSet.getInt("member_id");
                member.setMemberId(memberID);
                member.setFirstName(resultSet.getString("f_name"));
            }
            else{
                member.setMemberId(-1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return member;
    }

    public static void trainerLogin(){

    }

    public static void staffLogin(){

    }

    public static Member memberSignUp(Scanner scanner){
        scanner.nextLine();
        Member member = new Member();
        Payment payment = new Payment();
        payment.setTotal(150);
        payment.setDescription("NEW MEMBER REGISTRATION FEE");
        payment.setPaymentDate(new Date(System.currentTimeMillis()));
        System.out.println("Enter your first name: ");
        member.setFirstName(scanner.nextLine());
        System.out.println("Enter your last name: ");
        member.setLastName(scanner.nextLine());
        System.out.println("Enter your date of birth (yyyy-mm-dd): ");
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date utilDate;
        try {
            utilDate = dateformatter.parse(scanner.nextLine());
            member.setDob(new Date(utilDate.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Enter your gender: ");
        member.setGender(scanner.nextLine());
        System.out.println("Enter your email: ");
        member.setEmail(scanner.nextLine());
        payment = paymentPortal(member, scanner, payment);
        if(payment.getPaymentId() == -1){
            member.setMemberId(-1);
            System.out.println("Payment was not completed. Returning to main menu.");
            return member;
        }
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO members (f_name, l_name, dob, gender, email) VALUES (?, ?, ?, ?, ?) RETURNING member_id");
            statement.setString(1, member.getFirstName());
            statement.setString(2, member.getLastName());
            statement.setDate(3, member.getDob());
            statement.setString(4, member.getGender());
            statement.setString(5, member.getEmail());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                member.setMemberId(rs.getInt(1));
            }

            PreparedStatement statement2 = connection.prepareStatement("INSERT INTO payments (member_id, total, payment_method, payment_date, description) VALUES (?, ?::money, ?, ?, ?)");
            statement2.setInt(1, member.getMemberId());
            String totalStr = String.format("%.2f", payment.getTotal());
            statement2.setString(2, totalStr);
            statement2.setString(3, payment.getPaymentMethod());
            statement2.setDate(4, payment.getPaymentDate());
            statement2.setString(5, payment.getDescription());
            statement2.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            try {
                System.out.println("Something went wrong with the sign up process. Please try again later.");
                member.setMemberId(-1);
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return member;
    }

    public static void memberPortal(Member member, Scanner scanner){
        if(member.getMemberId() == -1){
            return;
        }
        boolean menFlag = true;
        int userInput = -1;
        System.out.println("Welcome, " + member.getFirstName() + "!");

        while(menFlag){
            
            System.out.println("Select one of the options below:");
            System.out.println("1. Profile");
            System.out.println("2. Dashboard");
            System.out.println("3. Training Sessions");
            System.out.println("4. Classes");
            System.out.println("5. Schedule");
            System.out.println("6. Log out");

            userInput = scanner.nextInt();

            if(userInput == 1){
                memberProfilePortal(member, scanner);
            }
            else if (userInput == 2){
                memberDashboard(member);
            }
            else if (userInput == 3){
                memberTrainingPortal(member, scanner);
            }
            else if (userInput == 4){
                memberClassPortal(member, scanner);
            }
            else if (userInput == 5){
                memberSchedulePortal(member, scanner);
            }
            else if (userInput == 6){
                System.out.println("Logged out successfully.");
                member = null;
                menFlag = false;
            }
            else {
                System.out.println("Unkown input. Please try again: \n");
            }
            
        }
    }

    public static void memberProfilePortal(Member member, Scanner scanner){
        boolean menFlag = true;
        int userInput = -1;

        while(menFlag){
            
            System.out.println("\nMEMBER PORTAL - Select one of the options below:");
            System.out.println("1. View Profile");
            System.out.println("2. Update Profile");
            System.out.println("3. View Health Metrics");
            System.out.println("4. Update Health Metrics");
            System.out.println("5. View Fitness Goals");
            System.out.println("6. Update Fitness Goals");
            System.out.println("7. Back\n");

            userInput = scanner.nextInt();

            if(userInput == 1){
                memberViewProfile(member);
            }
            else if (userInput == 2){
                memberUpdateProfile(member, scanner);
            }
            else if (userInput == 3){
                memberViewHealthMetrics(member);
            }
            else if (userInput == 4){
                memberUpdateHealthMetrics(member, scanner);
            }
            else if (userInput == 5){
                memberViewFitnessGoals(member);
            }
            else if (userInput == 6){
                memberUpdateFitnessGoals(member, scanner);
            }
            else if (userInput == 7){
                menFlag = false;
            }
            else {
                System.out.println("Unkown input. Please try again: \n");
            }
            
        }
    }

    public static void memberDashboard(Member member){
        try {
            PreparedStatement statement = connection.prepareStatement("select * from members where member_id = ?");
            statement.setInt(1, member.getMemberId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Retrieve the member_id from the result set
                member.setFirstName(resultSet.getString("f_name"));
                member.setLastName(resultSet.getString("l_name"));
                member.setGender(resultSet.getString("gender"));
                member.setDob(resultSet.getDate("dob"));
                member.setEmail(resultSet.getString("email"));
                member.setWeightCurrent(resultSet.getDouble("weight_curr"));
                member.setBodyFatCurrent(resultSet.getDouble("bodyfat_curr"));
                member.setCaloriesBase(resultSet.getInt("cals_base"));
                member.setWeightGoal(resultSet.getDouble("weight_goal"));
                member.setBodyFatGoal(resultSet.getDouble("bodyfat_goal"));
                member.setCaloriesGoal(resultSet.getInt("cals_goal"));
                member.setDateGoal(resultSet.getDate("date_goal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement statement = connection.prepareStatement("select * from exercises where member_id = ?");
            statement.setInt(1, member.getMemberId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("EXERCISE ROUTINES");
                System.out.println("Exercise Name: " + resultSet.getString("ex_name") );
                if(resultSet.getString("ex_type").equals("cardio")){
                    System.out.println(
                    "Distance: " + resultSet.getInt("distance") + "\n" +
                    "Current Record in Minutes: " + resultSet.getInt("time_curr") + "\n" +
                    "Target Record in Minutes: " + resultSet.getInt("time_goal")
                    );
                }
                else{
                    System.out.println(
                    "Reps: " + resultSet.getInt("ex_reps") + "\n" +
                    "Sets: " + resultSet.getInt("ex_sets") + "\n" +
                    "Current Personal Record: " + resultSet.getInt("pr_curr") + "\n" +
                    "Personal Record Goal: " + resultSet.getInt("pr_goal")
                    );
                }
                System.out.println("--------------------------");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String achievements = member.generateAchievements();
        System.out.println(achievements);
    }

    public static void memberTrainingPortal(Member member, Scanner scanner){
        boolean menFlag = true;
        int userInput = -1;

        while(menFlag){
            
            System.out.println("\nTRAINING PORTAL - Select one of the options below:");
            System.out.println("1. View Upcoming Training Sessions");
            System.out.println("2. Register for a Training Session");
            System.out.println("3. Back\n");

            userInput = scanner.nextInt();

            if(userInput == 1){
                memberViewEditSessions(member, scanner);
            }
            else if (userInput == 2){
                memberRegisterSession(member, scanner);
            }
            else if (userInput == 3){
                menFlag = false;
            }
            else {
                System.out.println("Unkown input. Please try again: \n");
            }
            
        }
    }

    public static void memberViewEditSessions(Member member, Scanner scanner){
        boolean hasSessions= false;
        try {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT sessions.*, trainers.f_name, trainers.l_name " +
                "FROM sessions " +
                "JOIN trainers ON sessions.trainer_id = trainers.trainer_id " +
                "WHERE sessions.member_id = ? AND sessions.session_date >= CURRENT_DATE"
            );
            
            statement.setInt(1, member.getMemberId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hasSessions = true;
                System.out.println("UPCOMING SESSIONS");
                System.out.println("Session ID#"+resultSet.getInt("session_id")+" with: " + resultSet.getString("f_name") );
                System.out.println("Session Date: " + resultSet.getDate("session_date") );
                System.out.println("Session Start: " + resultSet.getTime("session_start") );
                System.out.println("Session End: " + resultSet.getTime("session_end") );
                System.out.println("Session Price Per Slot: $" + resultSet.getDouble("price_per_slot") );

                System.out.println("--------------------------");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(hasSessions){
        System.out.println("Would you like to reschedule any your sessions? (y/n)");
        scanner.nextLine();
        String userInput = scanner.nextLine();
        if(userInput.equals("y")){
            System.out.println("Enter the session ID you would like to edit: ");
            int sessionID = scanner.nextInt();
            System.out.println("Enter the new session date (yyyy-mm-dd): ");
            scanner.nextLine();
            String sessionDate = scanner.nextLine();
            System.out.println("Enter the new session start time (hh:mm:ss): ");
            String sessionStart = scanner.nextLine();
            System.out.println("Enter the new session end time (hh:mm:ss): ");
            String sessionEnd = scanner.nextLine();

            try {
                PreparedStatement statement = connection.prepareStatement("update sessions set session_date=?, session_start=?, session_end=? WHERE session_id=?");
                statement.setString(1, sessionDate);
                statement.setString(2, sessionStart);
                statement.setString(3, sessionEnd);
                statement.setInt(4, sessionID);
                statement.execute();
                System.out.println("Session #" + sessionID + " has been updated"+ "\n");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Would you like to cancel any your sessions? (y/n)");
        userInput = scanner.nextLine();
        if(userInput.equals("y")){
            System.out.println("Enter the session ID you would like to cancel: ");
            int sessionID = scanner.nextInt();

            try {
                PreparedStatement statement = connection.prepareStatement("delete from sessions where session_id=?");
                statement.setInt(1, sessionID);
                statement.execute();
                System.out.println("Session #" + sessionID + " has been cancelled"+ "\n");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        }
        else{
        System.out.println("You have no upcoming sessions.");
        }
    }

    public static void memberRegisterSession(Member member, Scanner scanner){

    }

    public static void memberClassPortal(Member member, Scanner scanner){
                boolean menFlag = true;
        int userInput = -1;

        while(menFlag){
            
            System.out.println("\nCLASSES PORTAL - Select one of the options below:");
            System.out.println("1. View Your Classes");
            System.out.println("2. Register for a Class");
            System.out.println("3. Back\n");

            userInput = scanner.nextInt();

            if(userInput == 1){
                memberViewClasses(member);
            }
            else if (userInput == 2){
                memberRegisterClass(member, scanner);
            }
            else if (userInput == 3){
                menFlag = false;
            }
            else {
                System.out.println("Unkown input. Please try again: \n");
            }
            
        }
    }

    public static void memberSchedulePortal(Member member, Scanner scanner){

    }

    public static void memberViewClasses(Member member){
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT classes.* FROM classregs JOIN classes ON classregs.class_id = classes.class_id WHERE classregs.member_id = ?");
            statement.setInt(1, member.getMemberId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(
                    "Class Name: " + resultSet.getString("class_name") + "\n"
                );
                System.out.println("--------------------------");
            }
            System.out.println("\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void memberRegisterClass(Member member, Scanner scanner){
        
    }

    public static void memberViewProfile(Member member){
        try {
            PreparedStatement statement = connection.prepareStatement("select * from members where member_id = ?");
            statement.setInt(1, member.getMemberId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                member.setFirstName(resultSet.getString("f_name"));
                member.setLastName(resultSet.getString("l_name"));
                member.setGender(resultSet.getString("gender"));
                member.setDob(resultSet.getDate("dob"));
                member.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("\nMEMBER PROFILE");
        System.out.println("Name: " + member.getFirstName() + " " + member.getLastName());
        System.out.println("Date of Birth: " + member.getDob().toString());
        System.out.println("Gender: "+member.getGender());
        System.out.println("Email: " + member.getEmail()+"\n");
    }

    public static void memberUpdateProfile(Member member, Scanner scanner){
        scanner.nextLine();
        System.out.println("\nUpdate first name: ");
        member.setFirstName(scanner.nextLine());
        System.out.println("Update last name:");
        member.setLastName(scanner.nextLine());
        System.out.println("Update date of birth (yyyy-mm-dd)");
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date utilDate;
        try {
            utilDate = dateformatter.parse(scanner.nextLine());
            member.setDob(new Date(utilDate.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Update gender: ");
        member.setGender(scanner.nextLine());
        System.out.println("Update email: ");
        member.setEmail(scanner.nextLine());

        try {
            PreparedStatement statement = connection.prepareStatement("update members set f_name=?, l_name=?, dob=?, gender=?, email=? WHERE member_id=?");
            statement.setString(1, member.getFirstName());
            statement.setString(2, member.getLastName());
            statement.setDate(3, member.getDob());
            statement.setString(4, member.getGender());
            statement.setString(5, member.getEmail());
            statement.setInt(6, member.getMemberId());
            statement.execute();
            System.out.println("Member #" + member.getMemberId() + " profile has been updated"+ "\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void memberViewHealthMetrics(Member member){
        try {
            PreparedStatement statement = connection.prepareStatement("select * from members where member_id = ?");
            statement.setInt(1, member.getMemberId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Retrieve the member_id from the result set
                member.setWeightCurrent(resultSet.getDouble("weight_curr"));
                member.setBodyFatCurrent(resultSet.getDouble("bodyfat_curr"));
                member.setCaloriesBase(resultSet.getInt("cals_base"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("\nMEMBER HEALTH METRICS");
        System.out.println("Body Weight: " + member.getWeightCurrent());
        System.out.println("Bodyfat Percentage: " + member.getBodyFatCurrent());
        System.out.println("Caloric Intake: " + member.getCaloriesBase()+"\n");
    }

    public static void memberUpdateHealthMetrics(Member member, Scanner scanner){
        System.out.println("\nUpdate current body weight: ");
        member.setWeightCurrent(scanner.nextDouble());
        System.out.println("Update current body fat percentage:");
        member.setBodyFatCurrent(scanner.nextDouble());
        System.out.println("Update current caloric intake");
        member.setCaloriesBase(scanner.nextInt());

        try {
            PreparedStatement statement = connection.prepareStatement("update members set weight_curr=?, bodyfat_curr=?, cals_base=? WHERE member_id=?");
            statement.setDouble(1, member.getWeightCurrent());
            statement.setDouble(2, member.getBodyFatCurrent());
            statement.setInt(3, member.getCaloriesBase());
            statement.setInt(4, member.getMemberId());
            statement.execute();
            System.out.println("Member #" + member.getMemberId() + " health metrics have been updated"+ "\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void memberViewFitnessGoals(Member member){
        try {
            PreparedStatement statement = connection.prepareStatement("select * from members where member_id = ?");
            statement.setInt(1, member.getMemberId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Retrieve the member_id from the result set
                member.setWeightGoal(resultSet.getDouble("weight_goal"));
                member.setBodyFatGoal(resultSet.getDouble("bodyfat_goal"));
                member.setCaloriesGoal(resultSet.getInt("cals_goal"));
                member.setDateGoal(resultSet.getDate("date_goal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("\nMEMBER FITNESS GOALS");
        System.out.println("Body Weight Goal: " + member.getWeightGoal());
        System.out.println("Bodyfat Percentage Goal: " + member.getBodyFatGoal());
        System.out.println("Caloric Intake Goal: " + member.getCaloriesGoal()+"\n");
        if(member.getDateGoal() != null)
        System.out.println("To be achieved by: " + member.getDateGoal().toString());
    }

    public static void memberUpdateFitnessGoals(Member member, Scanner scanner){
        System.out.println("\nUpdate goal body weight: ");
        member.setWeightGoal(scanner.nextDouble());
        System.out.println("Update goal body fat percentage:");
        member.setBodyFatGoal(scanner.nextDouble());
        System.out.println("Update goal caloric intake");
        member.setCaloriesGoal(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Update goal target date (yyyy-mm-dd):");
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date utilDate;
        try {
            utilDate = dateformatter.parse(scanner.nextLine());
            member.setDateGoal(new Date(utilDate.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement statement = connection.prepareStatement("update members set weight_goal=?, bodyfat_goal=?, cals_goal=?, date_goal=? WHERE member_id=?");
            statement.setDouble(1, member.getWeightGoal());
            statement.setDouble(2, member.getBodyFatGoal());
            statement.setInt(3, member.getCaloriesGoal());
            statement.setDate(4, member.getDateGoal());
            statement.setInt(5, member.getMemberId());
            statement.execute();
            System.out.println("Member #" + member.getMemberId() + " fitness goals have been updated"+ "\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Payment paymentPortal(Member member, Scanner scanner, Payment payment){
        int userInput = -1;

        System.out.println("\nPAYMENT PORTAL");
        System.out.println("Total comes to $" + payment.getTotal());
        System.out.println("How would you like to pay?");
        System.out.println("1. Credit Card");
        System.out.println("2. Debit Card");
        System.out.println("3. Cash");
        System.out.println("4. Cancel\n");

        userInput = scanner.nextInt();

        if(userInput == 1){
            payment.setPaymentId(0);
            payment.setPaymentMethod("credit");
        }
        else if (userInput == 2){
            payment.setPaymentId(0);
            payment.setPaymentMethod("debit");
        }
        else if (userInput == 3){
            payment.setPaymentId(0);
            payment.setPaymentMethod("cash");
        }
        else if (userInput == 4){
            payment.setPaymentId(-1);
        }
        else {
            System.out.println("Unkown input.\n");
        }
        return payment;
    }
}