package tiy.invictus;

/**
 * Created by SC on 10/1/2016.
 */
public class ReqAddEvent {

    public int myUserID;
    public int myEventID;

    public ReqAddEvent(int myUserID, int myEventID) {
        this.myUserID = myUserID;
        this.myEventID = myEventID;
    }

    public int getMyUserID() {
        return myUserID;
    }

    public void setMyUserID(int myUserID) {
        this.myUserID = myUserID;
    }

    public int getMyEventID() {
        return myEventID;
    }

    public void setMyEventID(int myEventID) {
        this.myEventID = myEventID;
    }
}
