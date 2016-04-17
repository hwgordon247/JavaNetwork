package test;

/**
 * Created by hwgordon on 17/04/2016.
 */

import domain.User;
import domain.UserStorage;
import org.junit.Test;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;


public class UserStorageTest {

    UserStorage userStorage = new UserStorage();
    @Mock private User user;

    @Test
    public void canStoreUser() {
        userStorage.storeUser(user);
        assertEquals(1, userStorage.users.size() );

    }

}