package com.songyuankun.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Administrator
 */
@Configuration
@PropertySource(value = "classpath*:mongodb.properties")
public class MongoJdbc {
    @Value("${mongo.repset}")
    private String repset;
    /**
     * 数据库信息
     */
    @Value("${mongo.database}")
    private String database;
    /**
     * 用户名
     */
    @Value("${mongo.user}")
    private String user;
    /**
     * 密码
     */
    @Value("${mongo.password}")
    private String password;
    /**
     * 单个host允许链接的最大链接数
     */
    @Value("${mongo.connectionsPerHost}")
    private String connectionsPerHost;
    /**
     * 线程队列数
     */
    @Value("${mongo.threadsAllowedToBlockForConnectionMultiplier}")
    private String threadsAllowedToBlockForConnectionMultiplier;

    @Bean
    public MongoDatabase mongoDatabase() {
        List<ServerAddress> serverAddressList = new ArrayList<ServerAddress>();
        if (this.repset == null || "".equals(this.repset)) {
            throw new MongodbException("未配置ip地址和端口号！");
        }
        if (this.connectionsPerHost == null || "".equals(this.connectionsPerHost)) {
            throw new MongodbException("未配置单个host允许链接的最大链接数！");
        }
        if (this.threadsAllowedToBlockForConnectionMultiplier == null || "".equals(this.threadsAllowedToBlockForConnectionMultiplier)) {
            throw new MongodbException("未配置线程队列数！");
        }
        if (this.user == null || "".equals(this.user)) {
            throw new MongodbException("未配置用户名！");
        }
        if (this.password == null || "".equals(this.password)) {
            throw new MongodbException("未配置密码！");
        }
        if (this.database == null || "".equals(this.database)) {
            throw new MongodbException("未配置库名！");
        }
        String[] hostPorts = this.repset.split(",");
        for (String hostPort : hostPorts) {
            String[] hostPortArr = hostPort.split(":");
            if (hostPortArr.length != 2) {
                throw new MongodbException("mongodb主机配置异常");
            }
            String host = hostPortArr[0];
            String port = hostPortArr[1];
            ServerAddress serverAddress = new ServerAddress(host, Integer.parseInt(port));
            serverAddressList.add(serverAddress);
        }
        MongoClientOptions mongoClientOptions = new MongoClientOptions.Builder().connectionsPerHost(Integer.parseInt(this.connectionsPerHost))
                .threadsAllowedToBlockForConnectionMultiplier(Integer.parseInt(this.threadsAllowedToBlockForConnectionMultiplier)).build();
        MongoCredential credential = MongoCredential.createCredential(this.user, this.database, this.password.toCharArray());
        /* 客户端连接池 */
        MongoClient mongoClient = new MongoClient(serverAddressList, Collections.singletonList(credential), mongoClientOptions);
        return mongoClient.getDatabase(database);
    }
}