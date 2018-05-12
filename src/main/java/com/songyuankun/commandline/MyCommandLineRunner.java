package com.songyuankun.commandline;

import com.songyuankun.entity.User;
import com.songyuankun.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author SongYuanKun
 */
@Component
@Slf4j
public class MyCommandLineRunner implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public MyCommandLineRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... var1) {
        log.warn("This will be execute when the project was started!");
        User user = new User("songyuankun", 24);
        User saveUser = userRepository.insert(user);
        List<User> users = userRepository.findAll();
        log.info(users.toString());
        userRepository.deleteById(saveUser.getId());
        List<User> userList = userRepository.findByName("songyuankun");
        log.info("name:" + userList);
    }
}