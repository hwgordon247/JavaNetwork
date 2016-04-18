package test;

import domain.MenuFunctions;
import domain.Print;
import domain.User;
import domain.UserStorage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by hwgordon on 18/04/2016.
 */
public class MenuFunctionsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    MenuFunctions menuFunctions = new MenuFunctions();
    User user = mock(User.class);
    UserStorage userStorage = mock(UserStorage.class);
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

    @Test
    public void canViewPersonalTimeline(){
        menuFunctions.viewTimeline(print, user);
        verify(print).getMessages(user);
    }

    @Test
    public void viewSomeoneElseTimeline() {
        String name = "Spike";
        when(userStorage.userExist(name)).thenReturn(true);
        ByteArrayInputStream in = new ByteArrayInputStream(name.getBytes());
        System.setIn(in);
        menuFunctions.viewOtherTimeline(print, userStorage);
        assertEquals("Who do you want to see?\nSpike's Messages:\n", outContent.toString());
    }

    @Test
    public void viewSomeoneElseTimelineNotExist() {
        ByteArrayInputStream in = new ByteArrayInputStream("Spike".getBytes());
        System.setIn(in);
        menuFunctions.viewOtherTimeline(print, userStorage);
        assertEquals("Who do you want to see?\nPerson does no exist \n", outContent.toString());
    }

    @Test
    public void canFollowSomeone() {
        String name = "Spike";
        when(userStorage.userExist(name)).thenReturn(true);
        ByteArrayInputStream in = new ByteArrayInputStream(name.getBytes());
        System.setIn(in);
        menuFunctions.followSomeone(print, userStorage, user);
        assertEquals("Who do you want to follow?\nYou are now following Spike\n", outContent.toString());
    }

    @Test
    public void canViewHomeFeed() {
        menuFunctions.homeFeed(print, user);
        assertEquals("You are following:\n", outContent.toString());
    }

}