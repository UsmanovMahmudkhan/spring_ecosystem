package com.mahmudkhon.Spring_Data_Transaction.Service;

import com.mahmudkhon.Spring_Data_Transaction.DTOs.MemberCreationRequest;
import com.mahmudkhon.Spring_Data_Transaction.DTOs.MemberResponse;
import com.mahmudkhon.Spring_Data_Transaction.Exception.AlreadyAvailableException;
import com.mahmudkhon.Spring_Data_Transaction.Mapper.MemberMapper;
import com.mahmudkhon.Spring_Data_Transaction.Repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;
    private final MemberMapper mapper;

    public MemberService(MemberRepository repository, MemberMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public MemberResponse createMember(MemberCreationRequest request){
        if(!repository.existsByEmail(request.getEmail())){
            var member=mapper.createMember(request);
            repository.save(member);
            return mapper.memberResponse(member);
        }
        else {
            throw new AlreadyAvailableException("Members is already available");
        }

    }

    public List<MemberResponse>getAll(){
        return mapper.toResponseMembers(repository.findAll());
    }
}
