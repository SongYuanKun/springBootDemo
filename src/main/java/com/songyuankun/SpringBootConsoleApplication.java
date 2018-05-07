package com.songyuankun;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 非web程序
 *
 * @author SongYuanKun
 */
@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootConsoleApplication.class, args);

    }

    @Override
    public void run(String... args) {
        //do something
    }
}