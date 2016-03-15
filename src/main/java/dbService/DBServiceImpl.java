package dbService;

import dbService.dataSets.UsersDataSet;
import dbService.userDAO.UsersDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DBServiceImpl implements DBService {
    private static final String HIBERNATE_SHOW_SQL = "true";
    private static final String HIBERNATE_HBM2DDL_AUTO = "update";

    private final SessionFactory SESSION_FACTORY;
    public DBServiceImpl() {
        Configuration configuration = getMySqlConfiguration();
        SESSION_FACTORY = createSessionFactory(configuration);
    }

    private Configuration getMySqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(UsersDataSet.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection,driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/db_example");
        configuration.setProperty("hibernate.connection.username", "trully");
        configuration.setProperty("hibernate.connection.password", "trully");
        configuration.setProperty("hibernate.show_sql", HIBERNATE_SHOW_SQL);
        configuration.setProperty("hibernate.hbmdd1.auto", HIBERNATE_HBM2DDL_AUTO);
        return configuration;
    }

    public UsersDataSet getUserProfile(String login) {
        Session session = SESSION_FACTORY.openSession();
        UsersDAO dao = new UsersDAO(session);
        UsersDataSet dataSet = dao.getUser(login);
        session.close();
        return dataSet;
    }

    public void addUser(String login, String password) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        UsersDAO dao = new UsersDAO(session);
        dao.addUser(login, password);
        transaction.commit();
        session.close();
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
