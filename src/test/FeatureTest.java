package test;

import domain.JavaNetwork;
import domain.Print;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by hwgordon on 17/04/2016.
 */
public class FeatureTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

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


    String[] args = {};
    JavaNetwork javaNetwork = new JavaNetwork();

    @Test
    public void displayWelcomeMessage(){
        javaNetwork.welcome();
        assertEquals("Welcome to the Java Network\n", outContent.toString());
    }

    @Test
    public void signInNewUser() {
        ByteArrayInputStream in = new ByteArrayInputStream("Spike".getBytes());
        System.setIn(in);
        javaNetwork.enterName();
        assertEquals("Enter your name:\nHi Spike\n", outContent.toString());
    }

    @Test
    public void userCreateMessage() {
        ByteArrayInputStream in = new ByteArrayInputStream("hello".getBytes());
        System.setIn(in);
        javaNetwork.newUser("Spike");
        javaNetwork.createMessage();
        assertEquals(1, javaNetwork.user.messages().size());
        assertEquals("Hi Spike\nWrite your message:\n", outContent.toString());
    }

    @Test
    public void canViewPersonalTimeline(){
        ByteArrayInputStream in = new ByteArrayInputStream("hello".getBytes());
        System.setIn(in);
        javaNetwork.newUser("Spike");
        javaNetwork.createMessage();
        javaNetwork.viewTimeline();
        assertEquals("Hi Spike\nWrite your message:\nhello\n", outContent.toString());
    }





}
