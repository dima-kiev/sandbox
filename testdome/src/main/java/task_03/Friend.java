package task_03;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Friend {
    private Collection<Friend> friends;
    private String email;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {

        Collection<Friend> friendsOfFriend = friend.getFriends();

        if (friends.contains(friend)) {
            return true;
        }

        if (friend.getFriends().stream().flatMap(friend1 -> friend1.getFriends().stream()).anyMatch((f) -> f.canBeConnected(friend))) {
            return true;
        }

        return false;

    }


    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");
/*        Friend d = new Friend("D");
        Friend e = new Friend("E");
        Friend f = new Friend("F");*/

        a.addFriendship(b);
        b.addFriendship(c);
/*        c.addFriendship(d);
        d.addFriendship(e);
        //e.addFriendship(f);*/

        System.out.println(a.canBeConnected(c));
    }
}