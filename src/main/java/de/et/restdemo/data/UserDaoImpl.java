package de.et.restdemo.data;

import de.et.restdemo.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;

/**
 * Provides (quasi) persistent storage and access for Users.
 *
 * Created by Erik on 24.10.2015.
 */
@ApplicationScoped
public class UserDaoImpl implements UserDao {

    private Map<String, User> usersById = new HashMap<>();
    private int biggestId = 0;

    @Override
    public String saveUser(User user) {
        user.id = Integer.toString(biggestId++);
        usersById.put(user.id, user);
        return user.id;
    }

    @Override
    public User findUserById(String id) {
        return usersById.get(id);
    }

    @Override
    public Set<String> getAllUserIds() {
        return usersById.keySet();
    }

    @Override
    public void deleteUserById(String id) {
        usersById.remove(id);
    }

    @Override
    public void updateUser(User user) {
        usersById.put(user.id, user);
    }
}
