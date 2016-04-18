package domain; /**
 * Created by hwgordon on 17/04/2016.
 */

public class JavaNetwork {
    public User user;
    public static boolean exit = false;
    public UserStorage userStorage;
    public static Print print;
    public MenuFunctions menuFunctions;

    public JavaNetwork(){
        this.print = new Print();
        this.userStorage = new UserStorage();
        this.menuFunctions = new MenuFunctions();
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
        String name = MenuFunctions.scan();
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

    public void signOut() {
        System.out.print("Successfully Signed Out\n");
        enterName();
    }


    public void menuChoice() {
        String response = menuFunctions.scan();
        switch(response) {
            case "1":
                menuFunctions.createMessage(user);
                break;
            case "2":
                menuFunctions.viewTimeline(print, user);
                break;
            case "3":
                menuFunctions.viewOtherTimeline(print, userStorage);
                break;
            case "4":
                menuFunctions.followSomeone(print, userStorage, user);
                break;
            case "5":
                menuFunctions.homeFeed(print, user);
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




}
