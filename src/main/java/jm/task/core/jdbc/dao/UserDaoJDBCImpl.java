package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
//        Connection connection = Util.getConnection();
//        try (Statement statement = connection.createStatement()) {
//            String sql = """
//                    CREATE TABLE IF NOT EXISTS users (id BIGINT NOT NULL AUTO_INCREMENT,
//                      name VARCHAR(45) NOT NULL,
//                      last_name VARCHAR(45) NOT NULL,
//                      age SMALLINT NOT NULL,
//                      PRIMARY KEY (id))
//                    """;
//            statement.execute(sql);
//            System.out.println("Таблица users успешно создана");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void dropUsersTable() {
//        Connection connection = Util.getConnection();
//        try (Statement statement = connection.createStatement()) {
//            String sql = """
//                    DROP TABLE IF EXISTS users
//                    """;
//            statement.execute(sql);
//            System.out.println("Таблица users успешно удалена");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void saveUser(String name, String lastName, byte age) {
//        Connection connection = Util.getConnection();
//        try (Statement statement = connection.createStatement()) {
//            String sql = "INSERT INTO users (name, last_name, age) VALUES ('" + name + "', '" + lastName + "', " + age + ")";
//            statement.execute(sql);
//            System.out.println("User с именем – " + name + " добавлен в базу данных");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void removeUserById(long id) {
//        Connection connection = Util.getConnection();
//        try (Statement statement = connection.createStatement()) {
//            String sql = "DELETE FROM users WHERE id = " + id;
//            statement.execute(sql);
//            System.out.println("Из таблицы users успешно удалена следующая запись с id = " + id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
//        Connection connection = Util.getConnection();
//        try (Statement statement = connection.createStatement()) {
//            String sql = "SELECT * FROM users";
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                users.add(new User(resultSet.getString("name"),
//                        resultSet.getString("last_name"),
//                        resultSet.getByte("age")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return users;
    }

    public void cleanUsersTable() {
//        Connection connection = Util.getConnection();
//        try (Statement statement = connection.createStatement()) {
//            String sql = "TRUNCATE users";
//            statement.execute(sql);
//            System.out.println("Таблица users успешно очищена");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
