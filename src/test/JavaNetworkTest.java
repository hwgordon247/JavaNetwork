package test; /**
 * Created by hwgordon on 17/04/2016.
 */

import domain.JavaNetwork;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class JavaNetworkTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

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

//    @Test
//    public void welcomeMessage() {
//        javaNetwork.main(args);
//        assertEquals("Welcome to the Java Network\nPlease enter your name:\n", outContent.toString());
//    }
//
//    @Test
//    public void nameInput() {
//        javaNetwork.main(args);
//        ByteArrayInputStream in = new ByteArrayInputStream("Spike".getBytes());
//        System.setIn(in);
//        verify(console).printLine("Hi Spike");
//    }




    @Test
    public void out() {
        System.out.print("hello");
        assertEquals("hello", outContent.toString());
    }
//
//    @Test
//    public void err() {
//        System.err.print("hello again");
//        assertEquals("hello again", errContent.toString());
//    }

}