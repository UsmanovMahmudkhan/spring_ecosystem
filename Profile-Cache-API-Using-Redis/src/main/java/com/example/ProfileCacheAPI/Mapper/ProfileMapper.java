package com.example.ProfileCacheAPI.Mapper;

import com.example.ProfileCacheAPI.DTOs.ProfileRequest;
import com.example.ProfileCacheAPI.DTOs.ProfileResponse;
import com.example.ProfileCacheAPI.Entity.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {

    public Profile createProfileRequest(ProfileRequest request){
        Profile profile =new Profile();
        profile.setName(request.getName());
        profile.setCity(request.getCity());
        profile.setCountry(request.getCountry());

        return profile;
    }

    public ProfileResponse response(Profile profile){
        return new ProfileResponse(
                profile.getId(),
                profile.getName(),
                profile.getCity(),
                profile.getCountry(),
                profile.getUpdatedAt()
        );
    }
}
