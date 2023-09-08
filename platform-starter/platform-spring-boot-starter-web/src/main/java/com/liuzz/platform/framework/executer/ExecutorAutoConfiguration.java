package com.liuzz.platform.framework.executer;

import com.alibaba.ttl.threadpool.TtlExecutors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 默认线程池实现
 */
@AutoConfiguration
@Slf4j
public class ExecutorAutoConfiguration implements AsyncConfigurer {

    @Override
    @Bean
    public Executor getAsyncExecutor() {
        int cpuNum = Runtime.getRuntime().availableProcessors();
        int maxPoolSize = cpuNum * 2;
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(cpuNum);
        taskExecutor.setMaxPoolSize(maxPoolSize);
        taskExecutor.setQueueCapacity(2000);
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 关闭程序时会等待线程池中的任务运行完毕
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        // 关闭程序时会等待线程池中的任务运行完毕的超时时间
        taskExecutor.setAwaitTerminationSeconds(60);
        taskExecutor.setThreadNamePrefix("platform-");
        taskExecutor.initialize();
        log.debug("===== 自定义Boot内置线程池,CorePoolSize={},MaxPoolSize={},QueueCapacity={},NamePrefix={} =====",
                taskExecutor.getCorePoolSize(), taskExecutor.getMaxPoolSize(), taskExecutor.getQueueCapacity(), taskExecutor.getThreadNamePrefix());
        return TtlExecutors.getTtlExecutor(taskExecutor);
        //return taskExecutor;
    }

}
