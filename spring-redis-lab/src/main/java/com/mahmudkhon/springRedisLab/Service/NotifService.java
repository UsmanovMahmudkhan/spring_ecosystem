package com.mahmudkhon.springRedisLab.Service;

import com.mahmudkhon.springRedisLab.Model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotifService {

    @Autowired
    private StringRedisTemplate template;

    public boolean sendNotifcation(Notification notification){
        template.opsForSet().add(String.valueOf(notification.getId()),
                notification.getText());

        return true;
    }

    public String get(int key){
        return template.opsForSet().pop(String.valueOf(key));
    }
}
