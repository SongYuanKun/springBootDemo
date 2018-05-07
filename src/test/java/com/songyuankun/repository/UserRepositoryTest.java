package com.songyuankun.repository;

import com.songyuankun.MySpringBootApplication;
import com.songyuankun.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByName() {
        List<User> userList = userRepository.findByName("songyuankun");
        for (User user : userList) {
            Assert.assertEquals("songyuankun", user.getName());
        }
    }
}