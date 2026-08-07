package com.example.ProfileCacheAPI.Repository;

import com.example.ProfileCacheAPI.Entity.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile,Integer> {

}
