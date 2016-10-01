package tiy.invictus;

import javax.persistence.*;

/**
 * Created by Brice on 9/30/16.
 */

@Entity
@Table(name = "checkedIns")
public class CheckedIn {

    @Id
    @GeneratedValue
    int id;

    @Column (nullable = false)
    int userid;

    @Column (nullable = false)
    int eventid;

    public CheckedIn()
    {

    }
    public CheckedIn(int userid, int eventid) {

        this.userid = userid;
        this.eventid = eventid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }
}
