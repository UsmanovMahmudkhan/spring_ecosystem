package com.mahmudkhon.SpringDataMongoDB;


import org.springframework.data.mongodb.repository.MongoRepository;

@org.springframework.stereotype.Repository
public interface Repository extends MongoRepository<Entity,String> {

}
