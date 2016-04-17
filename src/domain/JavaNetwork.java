package domain; /**
 * Created by hwgordon on 17/04/2016.
 */

import java.util.Scanner;

public class JavaNetwork {
    public User user;
    public static boolean exit = false;
    public UserStorage userStorage = new UserStorage();
    public static Print print = new Print();


    public static void main(String[] args) {
        JavaNetwork javaNetwork = new JavaNetwork();
        javaNetwork.welcome();
        javaNetwork.enterName();
        while(exit == false) {
            print.getMenu();
            javaNetwork.menuChoice();
        }
    }

    public void welcome() {
        System.out.print("Welcome to the Java Network\n");
    }

    public void enterName() {
        System.out.print("Enter your name:\n");
        String name = scan();
        if (!userStorage.userExist(name)){
            user = new User(name);
            userStorage.storeUser(user);
            System.out.print("Hi " + name + "\n");
        }else{
            user = userStorage.getUser(name);
            System.out.print("Welcome back " + name + "\n");
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
            case "3":
                viewOtherTimeline();
                break;
            case "4":
                signOut();
                break;
            case "5":
                exit = true;
                break;
            default :
                System.out.print("N/A\n");
        }
    }

    public void createMessage(){
        System.out.print("Write your message:\n");
        String message = scan();
        user.storeMessage(message);
    }

    public void viewTimeline() {
        print.getMessages(user);
    }

    public void signOut() {
        System.out.print("Successfully Signed Out\n");
        enterName();
    }

    public void viewOtherTimeline() {
        System.out.print("Who do you want to see?\n");
        print.getUsers(userStorage);
        String name = scan();
        if (userStorage.userExist(name)){
            User chosenUser = userStorage.getUser(name);
            System.out.print(name + "'s Messages:\n");
            print.getMessages(chosenUser);
        }else{
            System.out.print("Person does no exist \n");
        }
    }





}
