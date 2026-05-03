package com.gymmembershipmanagementsystem.backend.service.impl;

import com.gymmembershipmanagementsystem.backend.dto.member.*;
import com.gymmembershipmanagementsystem.backend.entity.Gym;
import com.gymmembershipmanagementsystem.backend.entity.Member;
import com.gymmembershipmanagementsystem.backend.entity.Membership;
import com.gymmembershipmanagementsystem.backend.enums.Status;
import com.gymmembershipmanagementsystem.backend.repository.MemberRepository;
import com.gymmembershipmanagementsystem.backend.repository.MembershipRepository;
import com.gymmembershipmanagementsystem.backend.service.MemberService;
import com.gymmembershipmanagementsystem.backend.utils.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MembershipRepository membershipRepository;
    private final MemberMapper memberMapper;

    @Override
    public MemberResponseRecord addNewMember(MemberRequestRecord memberRecord) {
        // 1. check if member id exist
        Optional<Membership> membership = membershipRepository.findById(memberRecord.membershipId());

        if (membership.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Membership with id: " + memberRecord.membershipId() + " doesn't exist"
            );
        }

        // 2. validate capacity of the membership
        long membershipCount = memberRepository.countMembersByMembership_Id(memberRecord.membershipId());

        Member member = null;
        if (membershipCount < membership.get().getMaximumMembers()) {
            member = memberRepository.save(
                    Member.builder()
                            // can get membership from optional safely because it is checked before if
                            // it exists in Optional
                            .membership(membership.get())
                            .firstName(memberRecord.firstName())
                            .lastName(memberRecord.lastName())
                            .email(memberRecord.email())
                            .membershipStartDate(LocalDateTime.now())
                            .status(Status.ACTIVE)
                            .build()
            );
        }

        return memberMapper.mapToMemberResponse(member);
    }

    // todo create JOIN on all tables
    @Override
    public MemberResponseDetailedListRecord getAllMembers() {
        return new MemberResponseDetailedListRecord(
                memberRepository.findAll().stream()
                        .map(member -> {

                            Membership membership = member.getMembership();
                            Gym gym = membership.getGym();

                            return memberMapper.mapToMemberDetailedResposne(member, gym);
                        })
                        .toList()
        );
    }

    @Override
    public MemberResponseRecord cancelMembership(Long id) {
        Member member = memberRepository.getReferenceById(id);
        member.setStatus(Status.CANCELLED);

        return memberMapper.mapToMemberResponse(member);
    }

    @Override
    public MemberResponseRecord reactivateMembership(Long id) {
        Member member = memberRepository.getReferenceById(id);
        member.setStatus(Status.ACTIVE);

        return memberMapper.mapToMemberResponse(member);
    }
}
