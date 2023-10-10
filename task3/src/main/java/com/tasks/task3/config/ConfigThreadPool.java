package com.tasks.task3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.util.concurrent.ScheduledFuture;


@Configuration
public class ConfigThreadPool {

    @Bean
    public ThreadPoolTaskExecutor threadPoolExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(10);
        executor.setThreadNamePrefix("My-Thread: ");
        executor.initialize();
        return executor;
    }

    @Bean
    public TaskScheduler taskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    @Bean
    public ScheduledFuture<?> myTask(TaskScheduler taskScheduler) {
        Trigger trigger = new PeriodicTrigger(10 * 1000);
        return taskScheduler.schedule(new MyTask("Hey"), trigger);
    }
}
