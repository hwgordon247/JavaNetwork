package domain; /**
 * Created by hwgordon on 17/04/2016.
 */

import java.util.*;

public class User {
    private String name;
    private ArrayList messages = new ArrayList();
    private ArrayList following = new ArrayList();

    public User(String inputName) {
        name = inputName;
    }

    public void storeMessage(String message) {
        messages.add(message);
    }

    public void storeFollowing(User chosenUser){
        following.add(chosenUser);
    }

    public String name() {
        return name;
    }

    public ArrayList messages() {
        return messages;
    }

    public ArrayList following() {
        return following;
    }


}
