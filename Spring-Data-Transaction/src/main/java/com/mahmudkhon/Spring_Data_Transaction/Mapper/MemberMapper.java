package com.mahmudkhon.Spring_Data_Transaction.Mapper;

import com.mahmudkhon.Spring_Data_Transaction.DTOs.BookResponse;
import com.mahmudkhon.Spring_Data_Transaction.DTOs.MemberCreationRequest;
import com.mahmudkhon.Spring_Data_Transaction.DTOs.MemberResponse;
import com.mahmudkhon.Spring_Data_Transaction.Entity.Book;
import com.mahmudkhon.Spring_Data_Transaction.Entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    @Mapping(target = "id",ignore = true)
    Member createMember(MemberCreationRequest request);

    MemberResponse memberResponse(Member member);

    List<MemberResponse> toResponseMembers(List<Member>members);
}
