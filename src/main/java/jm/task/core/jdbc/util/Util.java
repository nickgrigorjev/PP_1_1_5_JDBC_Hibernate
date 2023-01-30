package jm.task.core.jdbc.util;
import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/usersdb";
    private static final String USERNAME = "nsgrigorjev";
    private static final String PASSWORD = "Jldq7fN09Kcn-F(W24";

    public static Session getSession () {
        Session session = null;
        SessionFactory sessionFactory;
        try{
             sessionFactory = new Configuration()
                    .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                    .setProperty("hibernate.connection.url", URL)
                    .setProperty("hibernate.connection.username", USERNAME)
                    .setProperty("hibernate.connection.password", PASSWORD)
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
            session = sessionFactory.openSession();
            return session;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return session;
    }

}
