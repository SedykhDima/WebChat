package frontend;

import dbService.DBService;
import dbService.DBServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class AccountProfile {
    private Map<String, UserProfile> accountProfile = new HashMap<>();

    public void addUser(String login, UserProfile userProfile) {
        accountProfile.put(login, userProfile);
    }

    public UserProfile getUserProfile(String login) {
        return accountProfile.get(login);
    }

    public void pushDataBase(String login, AccountProfile accountProfile) {
        DBService dbService = DBServiceImpl.newInstance();
        dbService.addUser(login, accountProfile.getUserProfile(login).getPassword());
    }

    public UserProfile getUserDataBase(String login) {
        DBService dbService = DBServiceImpl.newInstance();
        return new UserProfile(dbService.getUserProfile(login).getLogin(), dbService.getUserProfile(login).getPassword());
    }
}
