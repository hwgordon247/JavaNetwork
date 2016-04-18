package test; /**
 * Created by hwgordon on 17/04/2016.
 */

import domain.JavaNetwork;
import domain.Print;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class JavaNetworkTest {

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
    public void out() {
        System.out.print("hello");
        assertEquals("hello", outContent.toString());
    }

}