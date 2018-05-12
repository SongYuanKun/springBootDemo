package com.songyuankun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world
 *
 * @author SongYuanKun
 */


@RestController
//自动加载配置文件
@EnableAutoConfiguration
//自动扫描注解
@ComponentScan
//定时任务
@EnableScheduling

@SpringBootApplication
public class MySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }

    @RequestMapping("/hello")
    public String helloWord() {
        return "Hello World!";
    }
}
