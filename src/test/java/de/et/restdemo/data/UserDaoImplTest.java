package de.et.restdemo.data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import de.et.restdemo.model.User;
import org.junit.Test;

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
