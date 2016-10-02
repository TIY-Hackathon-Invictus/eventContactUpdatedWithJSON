package tiy.invictus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

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
//    public User login(@RequestBody User myUser) throws Exception {
//        System.out.println(myUser);
//        users.save(myUser);
//        return myUser;


    public User login(@RequestBody ReqLoginRequest lr) throws Exception {
        User myUser = users.findFirstByEmail(lr.getEmail());
        System.out.println("This is the email and password "+myUser.email + " " + myUser.password);
        if (myUser == null) {
            throw new Exception("No user exists; create a new user!");
        }
//      else if (!lr.getPassword().equals(user.getPassword())) {
//             throw new Exception("Password is incorrect");
//       }

        return myUser;
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public User register(@RequestBody User user) throws Exception {
        User compareUser = users.findFirstByEmail(user.getEmail());
        if (user.getEmail().equals(compareUser.getEmail())) {
            throw new Exception("User already exists!!!!!");
        }
        else  {

            users.save(user);
        }
        return user;
    }
//    @RequestMapping(path = "/home", method = RequestMethod.POST)
//    public ArrayList<Event> home(int userID) {
//        ArrayList<Event> eventList = new ArrayList<Event>();
//        Iterable<Event> allEvents = events.findAll();
//        for (Event event : allEvents) {
//            eventList.add(event);
//        }
//
//        return eventList;
//    }


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
    public Event eventInfo(@RequestBody ReqEventInfo ei) {
        Event event = events.findOne(ei.getEvent_ID());
        return event;
    }

    @RequestMapping(path = "/addEvent", method = RequestMethod.POST)
    public ArrayList<Event> addEvent(@RequestBody ReqAddEvent rae) throws Exception {
        User newUser = users.findOne(rae.getMyUserID());
        if (newUser == null) {
            throw new Exception("Unable to add event without an active user in the session");
        }
        Event newEvent = new Event();
        newEvent.setAdminUserID(newUser);
        events.save(newEvent);

        return getAllEvents();
    }
    @RequestMapping(path = "/contacts", method = RequestMethod.POST)
    public ArrayList<ContactRequest> contacts(@RequestBody ReqContacts rc) {
        ArrayList<ContactRequest> requestListThatAreTrue = new ArrayList<ContactRequest>();
        Iterable<ContactRequest> allRequests = contacts.findAll();
        User myUser = users.findOne(Integer.valueOf(rc.getContactID()));



        for (ContactRequest cr : allRequests) {
            if (cr.isFriend)
            {
                requestListThatAreTrue.add(cr);
            }
        }



        return requestListThatAreTrue;
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
