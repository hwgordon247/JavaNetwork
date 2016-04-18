package domain;

import java.util.Scanner;

/**
 * Created by hwgordon on 18/04/2016.
 */
public class MenuFunctions {

    public void createMessage(User user){
        System.out.print("Write your message:\n");
        String message = scan();
        user.storeMessage(message);
    }

    public void viewTimeline(Print print, User user) {
        print.getMessages(user);
    }

    public void viewOtherTimeline(Print print, UserStorage userStorage) {
        System.out.print("Who do you want to see?\n");
        print.getUsers(userStorage);
        String name = scan();
        findTimelineUser(name, userStorage, print);
    }

    private void findTimelineUser(String name, UserStorage userStorage, Print print) {
        if (userStorage.userExist(name)){
            viewChosenUser(name, userStorage, print);
        }else{
            notExist();
        }
    }

    private void viewChosenUser(String name, UserStorage userStorage, Print print) {
        User chosenUser = userStorage.getUser(name);
        System.out.print(name + "'s Messages:\n");
        print.getMessages(chosenUser);
    }

    private void notExist(){
        System.out.print("Person does no exist \n");
    }

    public void followSomeone(Print print, UserStorage userStorage, User user){
        System.out.print("Who do you want to follow?\n");
        print.getUsers(userStorage);
        String name = scan();
        findFollowUser(name,userStorage,user);
    }

    private void findFollowUser(String name, UserStorage userStorage, User user) {
        if (userStorage.userExist(name)){
            followChosenUser(name, userStorage, user);
        }else{
            notExist();
        }
    }

    private void followChosenUser(String name, UserStorage userStorage, User user) {
        User chosenUser = userStorage.getUser(name);
        System.out.print("You are now following " + name + "\n");
        user.storeFollowing(chosenUser);
    }

    public void homeFeed(Print print, User user){
        System.out.print("You are following:\n");
        print.getFollowing(user);
        viewFollowingMessages(print, user);
    }

    private void viewFollowingMessages(Print print, User user){
        for(int i = 0; i < user.following().size(); i++){
            User userX = (User) user.following().get(i);
            System.out.print("Messages from " + userX.name()+ ":\n");
            print.getMessages(userX);
        }
    }

    public static String scan() {
        Scanner reader = new Scanner(System.in).useDelimiter("\\n");
        String response = reader.next();
        return response;
    }
}
