package com.songyuankun.controller;

import com.songyuankun.entity.User;
import com.songyuankun.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author SongYuanKun
 */
@RestController
@RequestMapping("api")
public class ApiController {
    private final UserRepository userRepository;

    @Autowired
    public ApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "list/{name}", produces = "application/json")
    public List<User> returnJson(@PathVariable("name") String name) {
        return userRepository.findByName(name);
    }
}
