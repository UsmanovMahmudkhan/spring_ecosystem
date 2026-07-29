package com.mahmudkhon.Redis_Repository.Repository;

import com.mahmudkhon.Redis_Repository.Entity.Address;
import com.mahmudkhon.Redis_Repository.Entity.User;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<User, Long> {
}
