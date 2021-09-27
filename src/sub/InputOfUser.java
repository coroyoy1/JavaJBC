package sub;
import java.util.Scanner;

public class InputOfUser {

    private static int studentId, age;
    private static String firstName, lastName, gender;
    private static Scanner scan = new Scanner(System.in);
    private static StudentConstructor studentcons = new StudentConstructor();
    private static StudentUpdateConstructor studentupcons = new StudentUpdateConstructor();
    private static InputProcess inputProcess = new InputProcess();
    private String whereSet;

    public void displayAllRecord(){
        inputProcess.displayAllRecord();
    }
    public void insertInput(){
        System.out.println("Enter Student ID: "); studentId = scan.nextInt();
        System.out.println("Enter First Name: "); firstName = scan.next();
        System.out.println("Enter Last Name: "); lastName = scan.next();
        System.out.println("Enter Age: "); age = scan.nextInt();
        System.out.println("Enter Gender: "); gender = scan.next();

        studentcons.studentConstructor(studentId, firstName, lastName, age, gender);
        inputProcess.insertRecord(studentcons.getStudentID(), studentcons.getFirstName(),
            studentcons.getLastName(), studentcons.getAge(), studentcons.getGender());
    }
    public void deleteInput(){
        System.out.println("Enter Student ID: "); studentId = scan.nextInt();
        studentcons.setStudentID(studentId);
        inputProcess.deleteRecord(studentcons.getStudentID());
    }

    public void updateInput(){
        System.out.println("Enter Student ID: "); studentId = scan.nextInt();
        System.out.println("From what to update? ");
        int selectToUpdate = scan.nextInt();
        String outputPrint = "", getDataString;
        switch(selectToUpdate){
            case 1: 
                outputPrint = "Enter First Name: ";
                whereSet = "FirstName";
                break;
            case 2:
                outputPrint = "Enter Last Name: ";
                whereSet = "LastName";
                break;
            case 3:
                outputPrint = "Enter Age: ";
                whereSet = "Age";
                break;
            case 4:
                outputPrint = "Enter Gender: ";
                whereSet = "Gender";
                break;
        }
        System.out.println(outputPrint); getDataString = scan.next();
        studentupcons.setWhereSet(whereSet);
        studentcons.setStudentID(studentId);
        studentupcons.setAnyData(getDataString);
        inputProcess.updateRecord(studentcons.getStudentID(), studentupcons.getWhereSet(), studentupcons.getAnyData());
    }
}
