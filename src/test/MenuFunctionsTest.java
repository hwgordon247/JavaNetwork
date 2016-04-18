package test;

import domain.MenuFunctions;
import domain.Print;
import domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by hwgordon on 18/04/2016.
 */
public class MenuFunctionsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    MenuFunctions menuFunctions = new MenuFunctions();
    User user = mock(User.class);
    Print print = mock(Print.class);

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
    public void userCreateMessage() {
        ByteArrayInputStream in = new ByteArrayInputStream("hello".getBytes());
        System.setIn(in);
        menuFunctions.createMessage(user);
        assertEquals("Write your message:\n", outContent.toString());
    }

//    @Test
//    public void canViewPersonalTimeline(){
//        ByteArrayInputStream in = new ByteArrayInputStream("hello".getBytes());
//        System.setIn(in);
//        javaNetwork.newUser("Spike");
//        javaNetwork.createMessage();
//        javaNetwork.viewTimeline();
//        assertEquals("Hi Spike\nWrite your message:\nhello\n", outContent.toString());
//    }

}