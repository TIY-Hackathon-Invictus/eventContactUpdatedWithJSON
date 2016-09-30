package tiy.invictus;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SC on 9/30/2016.
 */
public class Database {

    @Autowired
    EventRepository events;

    @Autowired
    UserRepository users;

    @Autowired
    ContactRequestRepository contacts;

    @Autowired
    CheckedInRepository checkedInRepos;

    public Database(UserRepository users, EventRepository events) {
        this.events = events;
        this.users = users;
    }

    public User login(User user) {

//        Iterable<User> loggedIn;
        User myUser = new User();
        myUser = users.findFirstByEmail(user.getEmail());
        System.out.println("find first by email");
//        for (User thisUser : loggedIn) {
//            System.out.println(thisUser.getFirstName());
//            myUser.setFirstName(thisUser.getFirstName());
//        }

        return myUser;
    }
}
