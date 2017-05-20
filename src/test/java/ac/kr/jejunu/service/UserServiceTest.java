package ac.kr.jejunu.service;

import ac.kr.jejunu.common.entity.User;
import ac.kr.jejunu.common.entity.UserType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Boobby on 17-5-20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void getUser() {
        String email = "boo1984@naver.com";
        String name = "부은형";
        String userType = UserType.valueOf("student").name();
        User user = userService.getUser(email);

        assertThat(user.getEmail(), is(email));
        assertThat(user.getName(), is(name));
        assertThat(user.getUserType().name(), is(userType));
    }

    @Test
    public void saveUser() {
        User user = new User();
        String email = "test";
        String name = "aaa";
        UserType userType = UserType.valueOf("student");
        String password = "1234";

        user.setEmail(email);
        user.setName(name);
        user.setUserType(userType);
        user.setPassword(password);
        userService.register(user);

        User registeredUser = userService.getUser(email);

        assertThat(registeredUser.getEmail(), is(email));
        assertThat(registeredUser.getName(), is(name));
        assertThat(registeredUser.getUserType(), is(userType));
        assertThat(registeredUser.getPassword(), is(password));
    }

}