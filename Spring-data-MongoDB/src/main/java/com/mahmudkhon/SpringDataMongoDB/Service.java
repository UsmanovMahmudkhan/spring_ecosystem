package com.mahmudkhon.SpringDataMongoDB;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repository repository;

    public void save(EntityRequest request){
        var entity=new Entity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        repository.save(entity);
    }
}
