package de.et.restdemo.data;

import de.et.restdemo.model.User;

import java.util.Set;

/**
 * Dao for the user.
 *
 * Created by Erik on 25.10.2015.
 */
public interface UserDao {

    String saveUser(User user);

    User findUserById(String id);

    Set<String> getAllUserIds() ;

    void deleteUserById(String id);

    void updateUser(User user);

}
