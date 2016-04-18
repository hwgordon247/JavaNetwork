package domain; /**
 * Created by hwgordon on 17/04/2016.
 */

import java.util.Scanner;

public class JavaNetwork {
    public User user;
    public static boolean exit = false;
    public UserStorage userStorage;
    public static Print print;

    public JavaNetwork(){
        this.print = new Print();
        this.userStorage = new UserStorage();
    }


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
        analyseName(name);
    }

    private void analyseName(String name) {
        if (!userStorage.userExist(name)){
            newUser(name);
        }else{
            oldUser(name);
        }
    }

    public void newUser(String name) {
        user = new User(name);
        userStorage.storeUser(user);
        System.out.print("Hi " + name + "\n");
    }

    private void oldUser(String name) {
        user = userStorage.getUser(name);
        System.out.print("Welcome back " + name + "\n");
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
                followSomeone();
                break;
            case "5":
                homeFeed();
                break;
            case "6":
                signOut();
                break;
            case "7":
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
            viewChosenUser(name);
        }else{
            notExist();
        }
    }

    public void viewChosenUser(String name) {
        User chosenUser = userStorage.getUser(name);
        System.out.print(name + "'s Messages:\n");
        print.getMessages(chosenUser);
    }

    private void notExist(){
        System.out.print("Person does no exist \n");
    }

    public void followSomeone(){
        System.out.print("Who do you want to follow?\n");
        print.getUsers(userStorage);
        String name = scan();
        if (userStorage.userExist(name)){
            followChosenUser(name);
        }else{
            notExist();
        }
    }

    public void followChosenUser(String name) {
        User chosenUser = userStorage.getUser(name);
        System.out.print("You are now following " + name + "\n");
        user.storeFollowing(chosenUser);
    }

    public void homeFeed(){
        System.out.print("You are following:\n");
        print.getFollowing(user);
        viewFollowingMessages();
    }

    private void viewFollowingMessages(){
        for(int i = 0; i < user.following().size(); i++){
            User userX = (User) user.following().get(i);
            System.out.print("Messages from " + userX.name()+ ":\n");
            print.getMessages(userX);
        }
    }

    private String scan() {
        Scanner reader = new Scanner(System.in).useDelimiter("\\n");
        String response = reader.next();
        return response;
    }





}
