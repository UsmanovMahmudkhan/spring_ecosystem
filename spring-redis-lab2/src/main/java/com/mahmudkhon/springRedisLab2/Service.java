package com.mahmudkhon.springRedisLab2;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private RedisTemplate<String,User> template;

    public void save(UserRequest request){
       var user =new User();
       user.setName(request.getName());

       template.opsForValue().set(String.valueOf(user.getUuid()),user, Duration.ofSeconds(40));
    }


    public @Nullable User get(String key){
        return template.opsForValue().get(key);
    }
}
