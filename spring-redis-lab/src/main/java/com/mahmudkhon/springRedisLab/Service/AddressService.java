package com.mahmudkhon.springRedisLab.Service;

import com.mahmudkhon.springRedisLab.Model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.*;

@Service
public class AddressService {

    @Autowired
    private StringRedisTemplate template;

    public boolean saveAddress(Address address){
        template.opsForHash().put(valueOf(address.getId()), "city", address.getCity());
        template.opsForHash().put(valueOf(address.getId()), "country", address.getCountry());
        return true;
    }

    public List<Object> get(int id){
        return template.opsForHash().values(valueOf(id));
    }
}
