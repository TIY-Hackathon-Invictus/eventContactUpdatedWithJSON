package tiy.invictus;

/**
 * Created by SC on 10/1/2016.
 */
public class ReqAddEvent {

    public int myUserID;
    public Event myEvent;

    public ReqAddEvent(int myUserID, Event myEvent) {
        this.myUserID = myUserID;
        this.myEvent = myEvent;
    }

    public int getMyUserID() {
        return myUserID;
    }

    public void setMyUserID(int myUserID) {
        this.myUserID = myUserID;
    }

    public Event getMyEventID() {
        return myEvent;
    }

    public void setMyEventID(int myEventID) {
        this.myEvent = myEvent;
    }
}
