package tiy.invictus;

import javax.persistence.*;

/**
 * Created by Brice on 9/29/16.
 */

@Entity
@Table(name = "contactRequests")
public class ContactRequest {

    @Id
    @GeneratedValue
    int id;

    @Column (nullable = false)
    int contactorid;

    @Column (nullable = false)
    int contacteeid;

    public ContactRequest() {
    }

    public ContactRequest(int id, int contactorid, int contacteeid) {
        this.id = id;
        this.contactorid = contactorid;
        this.contacteeid = contacteeid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContactor() {
        return contactorid;
    }

    public void setContactor(int contactorid) {
        this.contactorid = contactorid;
    }

    public int getContactee() {
        return contacteeid;
    }

    public void setContactee(int contacteeid) {
        this.contacteeid = contacteeid;
    }
}
