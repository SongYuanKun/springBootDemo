package com.songyuankun;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

/**
 * 非web程序
 *
 * @author SongYuanKun
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
@EnableSpringConfigured
public class SpringBootConsoleApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootConsoleApplication.class, args);

    }

    @Override
    public void run(String... args) {
        //do something
    }
}