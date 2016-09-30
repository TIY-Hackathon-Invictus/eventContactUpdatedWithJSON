package tiy.invictus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brice on 9/29/16.
 */

@RestController
public class JSONController {

    @Autowired
    EventRepository events;

    @Autowired
    UserRepository users;

    @Autowired
    ContactRequestRepository contacts;

    @Autowired
    CheckedInRepository checkedInRepos;



    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public User login(String email, String password) throws Exception {
        Database myDB = new Database(users, events);
        System.out.println(users);
        System.out.println(email);
        User myUser = users.findFirstByEmail(email);
        System.out.println("works2");

//        myDB.login(myUser);

        if (myUser == null) {
            throw new Exception("No user exists; create a new user!");
        }
//        else if (!password.equals(user.getPassword())) {
//
//        }

//        session.setAttribute("user", user);


        return myUser;
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)

    public User register( String firstName, String lastName, String email, String password) throws Exception {


        User user = users.findFirstByEmail(email);
        if (user == null) {
            user = new User(firstName, lastName, email, password);
            users.save(user);
        }
        else if (!password.equals(user.getPassword())) {
            throw new Exception("Incorrect password");
        }
        return user;
    }



    @RequestMapping(path = "/home", method = RequestMethod.POST)
    public ArrayList<Event> home(int userID) {
        ArrayList<Event> eventList = new ArrayList<Event>();
        Iterable<Event> allEvents = events.findAll();
        for (Event event : allEvents) {
            eventList.add(event);
        }

        return eventList;
    }


    @RequestMapping(path = "/events", method = RequestMethod.POST)
    public ArrayList<Event> getAllEvents() {
        ArrayList<Event> eventList = new ArrayList<Event>();
        Iterable<Event> allEvents = events.findAll();
        for (Event event : allEvents) {
            eventList.add(event);
        }
        try{
            //   System.out.println("Catching a nap");
            //   Thread.sleep(3000);
            //   System.out.println("Power nap");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return eventList;
    }

    @RequestMapping(path = "/eventInfo", method = RequestMethod.POST)
    public Event eventInfo(int eventID) {
        Event event = events.findOne(eventID);
        return event;
    }

    @RequestMapping(path = "/addEvent", method = RequestMethod.POST)
    public ArrayList<Event> addEvent(User user, Event event) throws Exception {

        if (user == null) {
            throw new Exception("Unable to add event without an active user in the session");
        }
        event.adminUserID = user;

        events.save(event);

        return getAllEvents();
    }
    @RequestMapping(path = "/contacts", method = RequestMethod.POST)
    public ArrayList<User> contacts(int userID) {
        ArrayList<User> userList = new ArrayList<User>();
        Iterable<User> allUsers = users.findAll();
        for (User user : allUsers) {
            userList.add(user);
        }
        try{
            //   System.out.println("Catching a nap");
            //   Thread.sleep(3000);
            //   System.out.println("Power nap");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return userList;
    }

    @RequestMapping(path = "/contactInfo", method = RequestMethod.POST)
    public User contactInfo(int userID) {
        User user = users.findOne(userID);

        return user;
    }

    @RequestMapping(path = "/requests", method = RequestMethod.POST)
    public ArrayList<ContactRequest> requests() {
        ArrayList<ContactRequest> contactRequestsList = new ArrayList<ContactRequest>();
        Iterable<ContactRequest> allContacts = contacts.findAll();
        for (ContactRequest contactRequest : allContacts) {
            contactRequestsList.add(contactRequest);
        }
        try{
            //   System.out.println("Catching a nap");
            //   Thread.sleep(3000);
            //   System.out.println("Power nap");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return contactRequestsList;
    }
}
