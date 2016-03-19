package frontend;

/**
 * Created by Develop on 15.03.2016.
 */
public class UserProfile {
    private String login;
    private String password;

    public UserProfile(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
