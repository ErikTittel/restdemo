package de.et.restdemo.rest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import de.et.restdemo.data.UserDao;
import de.et.restdemo.data.UserDaoImpl;
import de.et.restdemo.model.User;
import org.junit.Test;

/**
 * Created by Erik on 31.10.2015.
 */
public class UserDaoImplTest {

    private UserDao dao = new UserDaoImpl();

    @Test
    public void saveUser() {
        User user = new User();
        user.name = "John";
        user.email = "john@mail.com";

        String id = dao.saveUser(user);

        assertThat(dao.findUserById(id).name, is("John"));
    }
}
