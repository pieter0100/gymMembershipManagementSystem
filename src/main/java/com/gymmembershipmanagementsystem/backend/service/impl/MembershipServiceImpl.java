package com.gymmembershipmanagementsystem.backend.service.impl;

import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipRequestRecord;
import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipResponseRecord;
import com.gymmembershipmanagementsystem.backend.entity.Membership;
import com.gymmembershipmanagementsystem.backend.repository.GymRepository;
import com.gymmembershipmanagementsystem.backend.repository.MembershipRepository;
import com.gymmembershipmanagementsystem.backend.service.MembershipService;
import com.gymmembershipmanagementsystem.backend.utils.MembershipMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MembershipServiceImpl implements MembershipService {

    private final MembershipRepository membershipRepository;
    private final GymRepository gymRepository;
    private final MembershipMapper membershipMapper;

    @Override
    public MembershipResponseRecord addMembership(MembershipRequestRecord membershipRecord) {
        // check if gym id exists
        if (!gymRepository.existsById(membershipRecord.gymId())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Gym with id: " + membershipRecord.gymId() + " doesn't exist"
            );
        }

        Membership savedMembership = membershipRepository.save(
                Membership.builder()
                        .gym(gymRepository.getReferenceById(membershipRecord.gymId()))
                        .name(membershipRecord.name())
                        .membershipPlanType(membershipRecord.membershipPlanType())
                        .monthlyPrice(membershipRecord.monthlyPrice())
                        .currencyCode(membershipRecord.currencyCode())
                        .durationMonths(membershipRecord.durationMonths())
                        .maximumMembers(membershipRecord.maximumMembers())
                        .build()
        );

        return membershipMapper.mapToMembershipResposne(savedMembership);
    }

    @Override
    public List<MembershipResponseRecord> getMemberships() {
        List<Membership> memberships = membershipRepository.findAll();

        return memberships.stream()
                .map(membership -> membershipMapper.mapToMembershipResposne(membership))
                .toList();
    }

}
