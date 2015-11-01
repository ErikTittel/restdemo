package de.et.restdemo.client;

import de.et.restdemo.data.UserDao;
import de.et.restdemo.model.User;
import de.et.restdemo.model.UserResponse;

import javax.inject.Inject;

/**
 * Simple Client.
 *
 * Created by Erik on 01.11.2015.
 */
public class UserClient {

    @Inject
    UserDao dao;

    public UserResponse saveUser(String name) {
        User user = new User();
        user.name = name;
        String id = dao.saveUser(user);
        UserResponse response = new UserResponse();
        response.message = id;
        return response;
    }

    public User getUser(String id) {
        return dao.findUserById(id);
    }
}
