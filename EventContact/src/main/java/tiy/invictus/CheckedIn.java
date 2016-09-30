package tiy.invictus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Brice on 9/30/16.
 */

@Entity
public class CheckedIn {

    @Id
    @GeneratedValue
    int id;

    @Column
    User user;

    @Column
    Event event;
}
