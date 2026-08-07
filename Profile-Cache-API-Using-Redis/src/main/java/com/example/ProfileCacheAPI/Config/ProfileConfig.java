package com.example.ProfileCacheAPI.Config;

import com.example.ProfileCacheAPI.DTOs.ProfileResponse;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
public class ProfileConfig {

    @Bean
    public RedisCacheManager manager(RedisConnectionFactory factory){

        var serilizer=new JacksonJsonRedisSerializer<>(ProfileResponse.class);

        var profileConfig= RedisCacheConfiguration
                .defaultCacheConfig()
                .computePrefixWith(cacheName -> "profile:user::"+cacheName+"::")
                .entryTtl(Duration.ofMinutes(3))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.string()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serilizer));

        return RedisCacheManager
                .builder()
                .disableCreateOnMissingCache()
                .withCacheConfiguration("profileId",profileConfig)
                .enableStatistics()
                .transactionAware()
                .cacheWriter(RedisCacheWriter.nonLockingRedisCacheWriter(factory))
                .build();

    }
}
