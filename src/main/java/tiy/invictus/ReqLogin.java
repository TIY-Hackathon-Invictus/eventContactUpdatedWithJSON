package tiy.invictus;

/**
 * Created by Brice on 10/1/16.
 */


// Request login with error for iOS
public class ReqLogin {

    public String errorMessage;
    public User myUser;

    public ReqLogin() {
    }

    public ReqLogin(String errorMessage, User myUser) {
        this.errorMessage = errorMessage;
        this.myUser = myUser;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public User getMyUser() {
        return myUser;
    }

    public void setMyUser(User myUser) {
        this.myUser = myUser;
    }
}
