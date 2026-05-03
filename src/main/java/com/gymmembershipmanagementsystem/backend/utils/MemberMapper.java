package com.gymmembershipmanagementsystem.backend.utils;

import com.gymmembershipmanagementsystem.backend.dto.member.MemberResponseDetailedRecord;
import com.gymmembershipmanagementsystem.backend.dto.member.MemberResponseRecord;
import com.gymmembershipmanagementsystem.backend.entity.Gym;
import com.gymmembershipmanagementsystem.backend.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public MemberResponseRecord mapToMemberResponse(Member member) {
        return new MemberResponseRecord(
                member.getId(),
                member.getMembership().getId(),
                member.getFirstName(),
                member.getLastName(),
                member.getEmail(),
                member.getMembershipStartDate(),
                member.getStatus()
        );
    }

    public MemberResponseDetailedRecord mapToMemberDetailedResposne(Member member, Gym gym) {
        return new MemberResponseDetailedRecord(
                member.getId(),
                member.getMembership().getId(),
                member.getMembership().getName(),
                gym.getName(),
                member.getFirstName(),
                member.getLastName(),
                member.getEmail(),
                member.getMembershipStartDate(),
                member.getStatus()
        );
    }
}
