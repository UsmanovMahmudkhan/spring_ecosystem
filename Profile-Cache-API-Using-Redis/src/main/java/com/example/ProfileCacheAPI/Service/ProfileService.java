package com.example.ProfileCacheAPI.Service;

import com.example.ProfileCacheAPI.DTOs.ProfileNameRequest;
import com.example.ProfileCacheAPI.DTOs.ProfileRequest;
import com.example.ProfileCacheAPI.DTOs.ProfileResponse;
import com.example.ProfileCacheAPI.Entity.Profile;
import com.example.ProfileCacheAPI.Exceptions.ProfileNotFoundException;
import com.example.ProfileCacheAPI.Mapper.ProfileMapper;
import com.example.ProfileCacheAPI.Repository.ProfileRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository repository;
    private final ProfileMapper profileMapper;


    public ProfileService(ProfileRepository repository, ProfileMapper profileMapper) {
        this.repository = repository;
        this.profileMapper = profileMapper;

    }

    public boolean createProfile(ProfileRequest request){
        repository.save(profileMapper.createProfileRequest(request));
        return true;
    }

    @Cacheable(cacheNames = "profileId",key = "#id")
    public ProfileResponse getById(Integer id) throws ProfileNotFoundException {
        if(!repository.existsById(id)){
            throw new ProfileNotFoundException();
        }

        var profile=repository.findById(id);
        var response=profileMapper.response(profile.get());

        return response;
    }

    @CacheEvict(cacheNames = "profileId",key = "#id")
    public ProfileResponse updateName(Integer id, ProfileNameRequest request) throws ProfileNotFoundException {

        Profile profile=repository.findById(id).orElseThrow(ProfileNotFoundException::new);


        if (request.getName() != null && !request.getName().isBlank()) {

            profile.setName(request.getName());

        };

        repository.save(profile);

        return profileMapper.response(profile);
    }
}
