package com.mahmudkhon.ConnectingRedistoSpring.Service;

import com.mahmudkhon.ConnectingRedistoSpring.Model.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final StringRedisTemplate template;

    public UserService(StringRedisTemplate template) {
        this.template = template;
    }

    public void save(User user){

        System.out.println(user.toString());
        template.opsForValue().set(String.valueOf(user.getId()),user.toString());
    }

    public String getUser(int key){
        var user=  template.opsForValue().get(String.valueOf(key));
        return user;
    }
}
