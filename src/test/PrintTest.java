package test;

import domain.Print;
import domain.User;
import domain.UserStorage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by hwgordon on 17/04/2016.
 */
public class PrintTest {
    Print print = new Print();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    UserStorage userStorage = Mockito.mock(UserStorage.class);
    User user = mock(User.class);
    ArrayList messages = new ArrayList();



    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void viewMenu() {
        print.getMenu();
        assertEquals("Main Menu\nPlease pick an option:\n1. Post Message\n2. View Personal Timeline\n3. View Someone's Timeline\n4. Follow Someone else\n5. View Home Feed\n6. Sign out\n7. Quit\n", outContent.toString());
    }

//    @Test
//    public void viewUsers(){
//        when(user.name()).thenReturn("Spike");
////        when(userStorage.users()).thenReturn(user);
//        Mockito.doReturn(user).when(userStorage).users();
//        print.getUsers(userStorage);
//        assertEquals("Spike", outContent.toString());
//    }

    @Test
    public void viewMessages(){
        messages.add("hello");
        when(user.messages()).thenReturn(messages);
        print.getMessages(user);
        assertEquals("hello\n", outContent.toString());
    }

}