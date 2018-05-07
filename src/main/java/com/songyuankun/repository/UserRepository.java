package com.songyuankun.repository;

import com.songyuankun.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author SongYuanKun
 */
public interface UserRepository extends MongoRepository<User, String> {


    @Query(value = "{ 'name':{$regex:?0,$options:'i'}}")

    /**
     * 使用自定义注解来实现复杂查询
     * @param name 姓名
     * @return 用户列表
     */
    List<User> findByName(String name);
}
