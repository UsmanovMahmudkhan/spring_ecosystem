package com.mahmudkhon.springRedisLab.Service;

import com.mahmudkhon.springRedisLab.Model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private StringRedisTemplate template;

    public boolean createProfile(Profile profile){
        template.opsForValue().set(String.valueOf(profile.getId()),profile.toString());
        return true;
    }

    public String getProfile(Integer id)
    {
        var key=String.valueOf(id);
        return template.opsForValue().get(key);
    }

    public String delete(Integer id){
        var key=String.valueOf(id);
        return template.opsForValue().getAndDelete(key);
    }
}
