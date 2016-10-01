package tiy.invictus;

/**
 * Created by SC on 10/1/2016.
 */
public class LoginRequest {

    public String email;
    public String password;

    public LoginRequest()
    {

    }

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
