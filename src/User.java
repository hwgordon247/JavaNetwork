/**
 * Created by hwgordon on 17/04/2016.
 */
import java.util.*;

public class User {
    String name;
    ArrayList messages = new ArrayList();

    public User(String inputName) {
        name = inputName;
    }

    public void storeMessage(String message) {
        messages.add(message);
    }


}
