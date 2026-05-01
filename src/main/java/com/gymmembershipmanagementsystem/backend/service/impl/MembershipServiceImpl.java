package com.gymmembershipmanagementsystem.backend.service.impl;

import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipRecord;
import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipResponseRecord;
import com.gymmembershipmanagementsystem.backend.entity.Membership;
import com.gymmembershipmanagementsystem.backend.repository.GymRepository;
import com.gymmembershipmanagementsystem.backend.repository.MembershipRepository;
import com.gymmembershipmanagementsystem.backend.service.MembershipService;
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

    @Override
    public MembershipResponseRecord addMembership(MembershipRecord membershipRecord) {
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

        return new MembershipResponseRecord(
                savedMembership.getId(),
                savedMembership.getGym().getId(),
                savedMembership.getName(),
                savedMembership.getMembershipPlanType(),
                savedMembership.getMonthlyPrice(),
                savedMembership.getCurrencyCode(),
                savedMembership.getDurationMonths(),
                savedMembership.getMaximumMembers()
        );
    }

    @Override
    public List<MembershipResponseRecord> getMemberships() {
        List<Membership> memberships = membershipRepository.findAll();

        return memberships.stream()
                .map(membership -> new MembershipResponseRecord(
                        membership.getId(),
                        membership.getGym().getId(),
                        membership.getName(),
                        membership.getMembershipPlanType(),
                        membership.getMonthlyPrice(),
                        membership.getCurrencyCode(),
                        membership.getDurationMonths(),
                        membership.getMaximumMembers()
                ))
                .toList();
    }

}
