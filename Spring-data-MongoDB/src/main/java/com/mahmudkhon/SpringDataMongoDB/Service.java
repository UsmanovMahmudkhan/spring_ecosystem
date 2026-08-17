package com.mahmudkhon.SpringDataMongoDB;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repository repository;

    @Autowired
    private AddressRepository addressRepository;

    public void save(EntityRequest request){

        var address=addressRepository.findById(request.getRequestAddressID()).orElseThrow();
        var entity=new Entity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());

        entity.setAddress(address);

        repository.save(entity);
    }

}
