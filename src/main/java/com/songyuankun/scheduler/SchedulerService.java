package com.songyuankun.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 定时任务
 *
 * @author Administrator
 */
@Service
@Slf4j
public class SchedulerService {
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("每5秒执行,当前时间:" + LocalDateTime.now());


    }

    @Scheduled(cron = "0 08 17 ? * *")
    public void fixedTimeExecution() {
        log.info("定时执行:" + LocalDateTime.now());
    }
}
