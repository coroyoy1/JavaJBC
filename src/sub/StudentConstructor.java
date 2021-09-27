package sub;

public class StudentConstructor {
    
    private int studentID;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;

    public int getStudentID(){ return studentID; }
    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName; }
    public int getAge(){ return age; }
    public String getGender(){ return gender; }

    public void setStudentID(int studentID){ this.studentID = studentID; }
    public void setFirstName(String firstName){ this.firstName = firstName; }
    public void setLastName(String lastName){ this.lastName = lastName; }
    public void setAge(int age){ this.age = age; }
    public void setGender(String gender){ this.gender = gender; }

    public void studentConstructor(int studentID, String firstName, String lastName, int age, String gender){
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }
}
