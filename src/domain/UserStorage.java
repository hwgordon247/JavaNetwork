package domain;

import java.util.ArrayList;

/**
 * Created by hwgordon on 17/04/2016.
 */
public class UserStorage {
    private ArrayList users = new ArrayList();

    public void storeUser(User user) {
        if(!userExist(user.name())){users.add(user);}
    }

    public boolean userExist(String name) {
        boolean response = false;
        for(int i=0; i< users.size(); i++){
            User userX = (User) users.get(i);
            if(userX.name().equals(name)) {
                response = true;
                break;
            }
        }
        return response;
    }

    public User getUser(String name) {
        User chosenUser = null;
        for(int i=0; i< users.size(); i++){
            User userX = (User) users.get(i);
            if(userX.name().equals(name)) {
                chosenUser = userX;
                break;
            }
        }
        return chosenUser;
    }

    public ArrayList users(){
        return users;
    }

}
