package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {   //DDL
        try (Session session = Util.getSession()) {
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
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {   //DDL
        try (Session session = Util.getSession()) {
            Transaction transaction = session.beginTransaction();
            String sql = """
                    DROP TABLE IF EXISTS users
                    """;
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
            System.out.println("Таблица users успешно удалена");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {  //DML
        Transaction transaction = null;
        try (Session session = Util.getSession()) {
            transaction = session.beginTransaction();
            session.save(new User(name, lastName, age));
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void removeUserById(long id) {  //DML
        Transaction transaction = null;
        try (Session session = Util.getSession()) {
            transaction = session.beginTransaction();
            String sql = "DELETE FROM users WHERE id = " + id;
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }


    }

    @Override
    public List<User> getAllUsers() {  //DML
        List<User> users = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = Util.getSession()) {
            transaction = session.beginTransaction();
            String sql = "SELECT * FROM users";
            users = session.createSQLQuery(sql).addEntity(User.class).list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {   //DDL
        try (Session session = Util.getSession()) {
            Transaction transaction = session.beginTransaction();
            String sql = "TRUNCATE users";
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
