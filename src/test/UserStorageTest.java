package test;

/**
 * Created by hwgordon on 17/04/2016.
 */

import domain.User;
import domain.UserStorage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UserStorageTest {

    UserStorage userStorage = new UserStorage();
//    @Mock private User user;
    User user = mock(User.class);


    @Test
    public void canStoreUser() {
        userStorage.storeUser(user);
        assertEquals(1, userStorage.users.size());
    }

    @Test
    public void doesUserExist() {
        when(user.name()).thenReturn("Spike");
        userStorage.storeUser(user);
        assertEquals(true, userStorage.userExist(user.name()));
    }

    @Test
    public void newUser() {
        assertEquals(false, userStorage.userExist(user.name()));
    }

    @Test
    public void canGetExistingUser() {
        when(user.name()).thenReturn("Spike");
        userStorage.storeUser(user);
        assertEquals(user, userStorage.getUser("Spike"));
    }
}