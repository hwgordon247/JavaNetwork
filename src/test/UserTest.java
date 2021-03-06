package test;

import domain.User;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by hwgordon on 17/04/2016.
 */
public class UserTest {
    String name = "Spike";
    User user = new User(name);
    User user2 = new User("Nikesh");


    @Test
    public void initializeWithName(){
        assertEquals(name, user.name());
    }

    @Test
    public void canStoreMessage() {
        user.storeMessage("hello");
        assertEquals(1, user.messages().size());
    }

    @Test
    public void canStoreFollowingUsers() {
        user.storeFollowing(user2);
        assertEquals(1, user.following().size());
    }
}