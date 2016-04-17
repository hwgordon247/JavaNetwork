package domain;

import java.util.ArrayList;

/**
 * Created by hwgordon on 17/04/2016.
 */
public class UserStorage {
    public ArrayList users = new ArrayList();

    public void storeUser(User user) {
        users.add(user);
    }

}
