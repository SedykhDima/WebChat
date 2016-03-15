package dbService;

import dbService.dataSets.UsersDataSet;

/**
 * Created by Develop on 15.03.2016.
 */
public interface DBService {
    UsersDataSet getUserProfile(String login);
    void addUser(String login, String password);
}
