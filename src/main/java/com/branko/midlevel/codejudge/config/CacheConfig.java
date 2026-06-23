package com.branko.midlevel.codejudge.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Value("${cache.caffeine.maximum-size}")
    private int maximumSize;

    @Value("${cache.caffeine.initial-capacity}")
    private int initialCapacity;

    @Value("${cache.caffeine.expire-after-write-minutes}")
    private int expireAfterWriteMinutes;

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(
                Caffeine.newBuilder()
                        .maximumSize(maximumSize)
                        .initialCapacity(initialCapacity)
                        .expireAfterWrite(Duration.ofMinutes(expireAfterWriteMinutes))
        );
        return cacheManager;
    }
}