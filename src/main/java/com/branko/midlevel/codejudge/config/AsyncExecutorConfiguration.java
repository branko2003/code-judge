package com.branko.midlevel.codejudge.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration
public class AsyncExecutorConfiguration {

    @Value("${asyncProcess.maxPoolSize}")
    private int maxPoolSize;

    @Value("${asyncProcess.corePoolSize}")
    private int corePoolSize;

    @Value("${asyncProcess.queueCapacity}")
    private int queueCapacity;

    @Bean(name = "judgeExecutor")
    public Executor judgeExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix("judge-");
        executor.initialize();
        return executor;
    }
}
