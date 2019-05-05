package com.songyuankun.controller;

import com.songyuankun.entity.User;
import com.songyuankun.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author SongYuanKun
 */
@RestController
@RequestMapping("api")
@Api(tags = "api测试")
@Slf4j
@RefreshScope
public class ApiController {
    private final UserRepository userRepository;

    @Value("${my.version}")
    private String version;

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

    @ApiOperation(value = "测试配置文件更新", notes = "获取所有用户信息")
    @GetMapping(value = "testRefresher", produces = "application/json")
    public String testRefresher() {
        log.info(version);
        return version;
    }

}
