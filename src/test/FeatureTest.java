package test;

import domain.JavaNetwork;
import domain.Print;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    public void na(){

    }
//    @Test
//    public void appRunThrough(){
//        javaNetwork.main(args);
//        ByteArrayInputStream in = new ByteArrayInputStream("Spike".getBytes());
//        System.setIn(in);
//        ByteArrayInputStream in2 = new ByteArrayInputStream("7".getBytes());
//        System.setIn(in2);
//        assertEquals("Welcome to the Java Network\nPlease enter your name:\n", outContent.toString());
//    }
}
