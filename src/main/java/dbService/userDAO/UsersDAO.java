package dbService.userDAO;

import dbService.dataSets.UsersDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsersDAO {

    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet getUser(String login) throws HibernateException {
        return (UsersDataSet) session.get(UsersDataSet.class, login);
    }

    public void addUser(String login, String password) throws HibernateException {
        session.save(new UsersDataSet(login, password));
    }

    public UsersDataSet getUserProfile(String login) {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        UsersDataSet usersDataSet = (UsersDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult();
        return usersDataSet;
    }
}
