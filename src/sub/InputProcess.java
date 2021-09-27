package sub;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InputProcess {

    private static DatabaseConnection dbConn = new DatabaseConnection();
    private static StudentConstructor studentcons = new StudentConstructor();

    public void displayAllRecord(){
        // Open a connection
        String QUERY = "SELECT * FROM room1";
        try(Connection conn = DriverManager.getConnection(
            dbConn.getDB_URL(), 
            dbConn.getUSER(), 
            dbConn.getPASS());
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY);) 
        {		      
            while(rs.next()){
                studentcons.studentConstructor(
                    rs.getInt("StudentID"), 
                    rs.getString("FirstName"), 
                    rs.getString("LastName"),
                    rs.getInt("Age"),
                    rs.getString("Gender"));

                System.out.print("ID: " + studentcons.getStudentID());
                System.out.print(", First Name: " + studentcons.getFirstName());
                System.out.print(", Last Name: " + studentcons.getLastName());
                System.out.print(", Age: " + studentcons.getAge());
                System.out.print(", Gender: " + studentcons.getGender());
                System.out.println();
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    public void insertRecord(int studentId, String firstName, String lastName, int age, String gender){
        // Open a connection
        try(Connection conn = DriverManager.getConnection(
        dbConn.getDB_URL(), 
        dbConn.getUSER(), 
        dbConn.getPASS());
        Statement stmt = conn.createStatement();) 
        {		      
            // Execute a query     
            String insertQuery = "INSERT INTO room1 VALUES ("+studentId+", '"+firstName+"', '"+lastName+"', "+age+", '"+gender+"')";
            String searchQuery = "SELECT * FROM room1 WHERE StudentID";

            System.out.println("Inserting records into the table...");  
            ResultSet rs = stmt.executeQuery(searchQuery);
            ArrayList<Integer> checkId = new ArrayList<Integer>();
            while(rs.next()){
                checkId.add(rs.getInt("StudentID"));
            }
            if(checkId.contains(studentId)){
                System.out.println("Record Already Exists! try again!");  
            }
            else{
                stmt.executeUpdate(insertQuery);
                System.out.println("Successfully Insert!");  
            }
            rs.close(); 
        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    public void deleteRecord(int studentId){
        // Open a connection
        try(Connection conn = DriverManager.getConnection(
        dbConn.getDB_URL(), 
        dbConn.getUSER(), 
        dbConn.getPASS());
        Statement stmt = conn.createStatement();) 
        {		      
            // Execute a query    
            String deleteQuery = "DELETE FROM room1 WHERE StudentID = "+studentId+"";
            String searchQuery = "SELECT * FROM room1 WHERE StudentID";
            ArrayList<Integer> checkId = new ArrayList<Integer>();

            ResultSet rs = stmt.executeQuery(searchQuery);
            while(rs.next()){
                checkId.add(rs.getInt("StudentID"));
            }

            if(checkId.contains(studentId)){
                stmt.executeUpdate(deleteQuery);
                System.out.println("Successfully Deleted!");  
            }
            else{
                System.out.println("Record not found! Try Again!"); 
            }
            rs.close();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    public void updateRecord(int studentId, String whereSet, String getData){
        // Open a connection
        try(Connection conn = DriverManager.getConnection(
        dbConn.getDB_URL(), 
        dbConn.getUSER(), 
        dbConn.getPASS());
        Statement stmt = conn.createStatement();) 
        {	
            String updateQuery;
            if(isNumeric(getData) == true){
                updateQuery = "UPDATE room1 " +
                "SET "+whereSet+" = "+getData+" WHERE StudentID = "+studentId+"";
            }
            else{
                updateQuery = "UPDATE room1 " +
                "SET "+whereSet+" = '"+getData+"' WHERE StudentID = "+studentId+"";
            }     
            String searchQuery = "SELECT * FROM room1 WHERE StudentID";
            ArrayList<Integer> checkId = new ArrayList<Integer>();

            ResultSet rs = stmt.executeQuery(searchQuery);
            while(rs.next()){
                checkId.add(rs.getInt("StudentID"));
            }

            if(checkId.contains(studentId)){
                stmt.executeUpdate(updateQuery);
                System.out.println("Successfully Update!");  
            }
            else{
                System.out.println("Record not found! Try Again!"); 
            }
            rs.close();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    public static boolean isNumeric(String str) { 
        try {  
          Integer.parseInt(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
    }
}
