package com.songyuankun.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
public class AsyncTaskService {

    // 通过@Async注解表明该方法是一个异步方法，如果注解在类级别，表明该类下所有方法都是异步方法，而这里的方法自动被注入使用ThreadPoolTaskExecutor 作为 TaskExecutor
    @Async

    public void executeAsyncTask(Integer i) {
        System.out.println("执行异步任务：" + i);
    }

}