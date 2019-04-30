package com.songyuankun.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 用户实体
 *
 * @author SongYuanKun
 */

//指定对应的集合
@Document(collection = "user")

@Getter
@Setter
@ToString
public class User {
    @Id
    private String id;
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
