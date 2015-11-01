package de.et.restdemo.client;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import de.et.restdemo.data.UserDao;
import de.et.restdemo.data.UserDaoImpl;
import de.et.restdemo.model.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class UserClientIT {

    @Deployment
    public static JavaArchive microDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class).addClass(UserClient.class).addClass(UserDao
                .class).addClass(UserDaoImpl.class).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(jar.toString(true));
        return jar;
    }

    @Inject
    UserClient client;

    @Test
    public void saveUser() {
        String id = client.saveUser("John").message;
        User user = client.getUser(id);
        assertThat(user.name, is("John"));
    }
}
