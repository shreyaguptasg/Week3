package Day1.singly_linked_list;

import java.util.ArrayList;

class User{
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds;
    User next;
    User(int userId, String name, int age){
        this.userId=userId;
        this.name=name;
        this.age=age;
        this.friendIds= new ArrayList<>();
        this.next = null;
    }
}
public class SocialMediaFriendConnections {
    private User head;
    //add a new user to the first place  media
    public void addFirst(int userId, String name, int age){
        User newUser = new User(userId,name,age);
        if(head==null){
            head= newUser;
            return;
        }
        head.next= newUser;
        newUser=head;
    }
    //add user to the last index
    public void addLast(int userId, String name, int age){
        User newUser = new User(userId,name,age);
        User current = head;
        if(head==null){
           // head u7
        }
    }
    public static void main(String[] args) {

    }
}
