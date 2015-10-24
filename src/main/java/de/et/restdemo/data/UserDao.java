package de.et.restdemo.data;

import de.et.restdemo.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Provides (quasi) persistent storage and access for Users.
 *
 * Created by Erik on 24.10.2015.
 */
public enum UserDao {

    INSTANCE;

    private Map<String, User> usersById = new HashMap<>();
    private int biggestId = 0;

    public String saveUser(User user) {
        user.id = Integer.toString(biggestId++);
        usersById.put(user.id, user);
        return user.id;
    }

    public User findUserById(String id) {
        return usersById.get(id);
    }

    public Set<String> getAllUserIds() {
        return usersById.keySet();
    }

    public void deleteUserById(String id) {
        usersById.remove(id);
    }
}
