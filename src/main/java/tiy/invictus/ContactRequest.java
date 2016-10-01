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

    @ManyToOne
    User contactor;

    @ManyToOne
    User contactee;

    @Column (nullable = false)
    boolean isFriend = false;


    public ContactRequest() {
    }

    public ContactRequest(int id, User contactor, User contactee, boolean isFriend) {
        this.id = id;
        this.contactor = contactor;
        this.contactee = contactee;
        this.isFriend = isFriend;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getContactor() {
        return contactor;
    }

    public void setContactor(User contactor) {
        this.contactor = contactor;
    }

    public User getContactee() {
        return contactee;
    }

    public void setContactee(User contactee) {
        this.contactee = contactee;
    }

    public boolean isFriend() {
        return isFriend;
    }

    public void setFriend(boolean friend) {
        isFriend = friend;
    }
}
