package tiy.invictus;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by Brice on 9/29/16.
 */

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue
    int eventid;

    @Column (nullable = false)
    String title;

    @Column (nullable = false)
    String address;

    @Column (nullable = false)
    String description;

    @ManyToOne
    User adminUserID;

    @Column (nullable = false)
    String dateAndTime;



    public Event() {
    }

    public Event(String title, String address, String description, User adminUserID, User attendees, String dateAndTime) {
        this.title = title;
        this.address = address;
        this.description = description;
        this.adminUserID = adminUserID;
        this.dateAndTime = dateAndTime;
    }

    public int getEventId() {
        return eventid;
    }

    public void setEventId(int id) {
        this.eventid = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAdminUserID() {
        return adminUserID;
    }

    public void setAdminUserID(User adminUserID) {
        this.adminUserID = adminUserID;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
