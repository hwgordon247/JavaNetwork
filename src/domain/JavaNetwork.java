package domain; /**
 * Created by hwgordon on 17/04/2016.
 */

import java.util.Scanner;

public class JavaNetwork {
    public User user;
    public static boolean exit = false;
    public UserStorage userStorage = new UserStorage();


    public static void main(String[] args) {
        JavaNetwork javaNetwork = new JavaNetwork();
        javaNetwork.welcome();
        javaNetwork.enterName();
        while(exit == false) {
            javaNetwork.menu();
            javaNetwork.menuChoice();
        }
    }

    public void welcome() {
        System.out.print("Welcome to the Java Network\n");
    }

    public void menu() {
        System.out.print("Main Menu\nPlease pick an option:\n");
        System.out.print("1. Post Message\n");
        System.out.print("2. View Timeline\n");
        System.out.print("3. View Someone else\n");
        System.out.print("4. Sign out\n");
        System.out.print("5. Quit\n");
    }

    public void enterName() {
        System.out.print("Enter your name:");
        String name = scan();
        if (!userStorage.userExist(name)){
            user = new User(name);
            System.out.print("Hi " + name + "\n");
        }else{
            System.out.print("Welcome back" + name + "\n");
        }

    }

    public String scan() {
        Scanner reader = new Scanner(System.in).useDelimiter("\\n");
        String response = reader.next();
        return response;
    }

    public void menuChoice() {
        String response = scan();
        switch(response) {
            case "1":
                createMessage();
                break;
            case "2":
                viewTimeline();
                break;
            case "4":
                signOut();
                break;
            case "5":
                exit = true;
                break;
            default :
                System.out.print("N/A");
        }
    }

    public void createMessage(){
        System.out.print("Write your message:");
        String message = scan();
        user.storeMessage(message);
    }

    public void viewTimeline() {
        for(int i = 0; i < user.messages().size();i ++){
            System.out.print(user.messages().get(i) + "\n");
        }
    }

    public void signOut() {
        System.out.print("Successfully Signed Out\n");
        enterName();
    }



}
