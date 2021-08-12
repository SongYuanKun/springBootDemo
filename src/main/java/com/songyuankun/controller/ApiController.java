package com.songyuankun.controller;

import com.songyuankun.entity.User;
import com.songyuankun.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author SongYuanKun
 */
@RestController
@RequestMapping("api")
@Api(tags = "api测试")
@Slf4j
public class ApiController {
    private final UserRepository userRepository;

    @Autowired
    public ApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ApiOperation(value = "按姓名获取用户列表", notes = "获取所有用户信息")
    @GetMapping(value = "list/{name}", produces = "application/json")
    @Cacheable(value = "usersByName", key = "#name")
    public List<User> returnJson(@PathVariable("name") String name) {
        return userRepository.findByName(name);
    }

}
