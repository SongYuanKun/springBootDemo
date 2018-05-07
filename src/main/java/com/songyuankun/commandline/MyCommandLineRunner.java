package com.songyuankun.commandline;

import com.mongodb.client.MongoDatabase;
import com.songyuankun.entity.User;
import com.songyuankun.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author SongYuanKun
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Resource
    private UserRepository userRepository;

    @Autowired
    private MongoDatabase mongoDatabase;

    @Override
    public void run(String... var1) {
        System.out.println("This will be execute when the project was started!");
        User user = new User("songyuankun", 24);
        User saveUser = userRepository.insert(user);
        List<User> users = userRepository.findAll();
        System.out.println(users);
        userRepository.deleteById(saveUser.getId());
        List<User> userList = userRepository.findByName("songyuankun");
        System.out.println("name:" + userList);


    }
}