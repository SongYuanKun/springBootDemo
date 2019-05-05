package com.songyuankun.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 配置文件动态刷新
 *
 * @author songyuankun
 */

@Component
public class ContextRefresherScheduler {
    private final ContextRefresher contextRefresher;

    @Autowired
    public ContextRefresherScheduler(ContextRefresher contextRefresher) {
        this.contextRefresher = contextRefresher;
    }


    @Scheduled(fixedRate = 5000, initialDelay = 3 * 1000)
    public void refresh() {
        Set<String> result = contextRefresher.refresh();
        System.err.println(result);
    }
}



