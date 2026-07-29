package com.mahmudkhon.Redis_Repository.Service;

import com.mahmudkhon.Redis_Repository.Entity.User;
import com.mahmudkhon.Redis_Repository.Repository.Repository;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public void save(User user){
       repository.save(user);
    }

    public List<User>getALL(){
        return (List<User>) repository.findAll();
    }

    public void remove(Long id){
        var user=repository.findById(id).orElseThrow();
        repository.delete(user);
    }
}
