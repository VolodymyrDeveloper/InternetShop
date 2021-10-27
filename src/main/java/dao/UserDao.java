package dao;

import model.User;

import java.util.List;

/**
 * Created by Igor on 10/8/2019.
 */
public interface UserDao {
    void save(User user);

    void update(User user);

    void delete(User user);

    User getByName(String name);

    List<User> getAll();

    User getById(long id);
}