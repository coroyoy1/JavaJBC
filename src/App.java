import sub.*;
import java.util.Scanner;

public class App {

    //Iteration with different classes
    private static Scanner scan = new Scanner(System.in);
    private static int selectNumber = 0;
    private static App app = new App();
    private static InputOfUser inputOfUser = new InputOfUser();

    //Execute Code
    public static void main(String[] args) throws Exception {
        app.selection();
    }

    private void selection(){
        System.out.println("Select Number: ");
        selectNumber = scan.nextInt();

        switch(selectNumber){
            case 1: 
                inputOfUser.displayAllRecord();
                app.selection();
                break;
            case 2:
                inputOfUser.insertInput();
                app.selection();
                break;
            case 3:
                inputOfUser.deleteInput();
                app.selection();
                break;
            case 4:
                inputOfUser.updateInput();
                app.selection();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
}
