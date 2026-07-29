package com.mahmudkhon.Redis_Repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class Config {

    @Bean
    public RedisStandaloneConfiguration configuration() {
        RedisStandaloneConfiguration redisStandaloneConfiguration
                = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName("redis-server");
        redisStandaloneConfiguration.setPort(6379);
        return redisStandaloneConfiguration;
    }

    @Bean
    public RedisConnectionFactory connectionFactory(RedisStandaloneConfiguration standaloneConfiguration){
        return new LettuceConnectionFactory(standaloneConfiguration);
    }
}
