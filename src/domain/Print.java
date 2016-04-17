package domain;

/**
 * Created by hwgordon on 17/04/2016.
 */
public class Print {


    public void getMenu() {
        System.out.print("Main Menu\nPlease pick an option:\n");
        System.out.print("1. Post Message\n");
        System.out.print("2. View Timeline\n");
        System.out.print("3. View Someone else\n");
        System.out.print("4. Sign out\n");
        System.out.print("5. Quit\n");
    }

    public void getMessages(User chosenUser) {
        for(int i = 0; i < chosenUser.messages().size();i ++){
            System.out.print(chosenUser.messages().get(i) + "\n");
        }
    }

    public void getUsers(UserStorage userStorage) {
        for(int i = 0; i < userStorage.users().size(); i ++){
            User userX = (User) userStorage.users().get(i);
            System.out.print(userX.name() + "\n");
        }
    }
}
