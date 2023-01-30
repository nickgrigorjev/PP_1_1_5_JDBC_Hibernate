package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Session session = Util.getSession();
        Transaction transaction = session.beginTransaction();
        String sql = """
                    CREATE TABLE IF NOT EXISTS users (id BIGINT NOT NULL AUTO_INCREMENT,
                      name VARCHAR(45) NOT NULL,
                      last_name VARCHAR(45) NOT NULL,
                      age SMALLINT NOT NULL,
                      PRIMARY KEY (id))
                    """;
        session.createSQLQuery(sql).executeUpdate();
        transaction.commit();
        System.out.println("Таблица успешно создана");
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSession();
        Transaction transaction = session.beginTransaction();
        String sql = """
                    DROP TABLE IF EXISTS users
                    """;
        session.createSQLQuery(sql).executeUpdate();
        transaction.commit();
        System.out.println("Таблица users успешно удалена");
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(new User(name,lastName,age));
        transaction.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getSession();
        Transaction transaction = session.beginTransaction();
        String sql = "DELETE FROM users WHERE id = " + id;
        session.createSQLQuery(sql).executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users;
        Session session = Util.getSession();
        Transaction transaction = session.beginTransaction();
        String sql = "SELECT * FROM users";
        users  = session.createSQLQuery(sql).addEntity(User.class).list();
        transaction.commit();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSession();
        Transaction transaction = session.beginTransaction();
        String sql = "TRUNCATE users";
        session.createSQLQuery(sql).executeUpdate();
        transaction.commit();
        session.close();
    }
}
