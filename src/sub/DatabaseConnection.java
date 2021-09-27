package sub;

public class DatabaseConnection {
    private String DB_URL = "jdbc:mysql://localhost/students";
    private String USER = "root";
    private String PASS = "1234";

    public String getDB_URL(){ return DB_URL; }
    public String getUSER(){ return USER; }
    public String getPASS(){ return PASS; }


}
