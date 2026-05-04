package com.gymmembershipmanagementsystem.backend.service.impl;

import com.gymmembershipmanagementsystem.backend.dto.gym.GymRequestRecord;
import com.gymmembershipmanagementsystem.backend.dto.gym.GymResponseRecord;
import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipResponseListRecord;
import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipResponseRecord;
import com.gymmembershipmanagementsystem.backend.entity.Gym;
import com.gymmembershipmanagementsystem.backend.entity.Membership;
import com.gymmembershipmanagementsystem.backend.repository.GymRepository;
import com.gymmembershipmanagementsystem.backend.repository.MembershipRepository;
import com.gymmembershipmanagementsystem.backend.service.GymService;
import com.gymmembershipmanagementsystem.backend.utils.GymMapper;
import com.gymmembershipmanagementsystem.backend.utils.MembershipMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GymServiceImpl implements GymService {

    private final GymRepository gymRepository;
    private final MembershipRepository membershipRepository;
    private final MembershipMapper membershipMapper;
    private final GymMapper gymMapper;

    // creates new gym
    @Override
    public Gym addGym(GymRequestRecord gymRecord) {
        if (gymRepository.existsGymByName(gymRecord.name())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Gym with name: " + gymRecord.name() + " already exists"
            );
        }

        return gymRepository.save(
                Gym.builder()
                        .name(gymRecord.name())
                        .phoneNumber(gymRecord.phoneNumber())
                        .street(gymRecord.street())
                        .city(gymRecord.city())
                        .country(gymRecord.country())
                        .postalCode(gymRecord.postalCode())
                        .build()
        );
    }

    // get all gyms
    @Override
    public List<GymResponseRecord> getGyms() {
        return gymRepository.findAll().stream()
                .map(gym -> gymMapper.mapToGymResponseRecord(gym))
                .toList();
    }

    @Override
    public MembershipResponseListRecord getAllMembershipPlansFromGym(Long gymId) {
        // check if gym id exists in db
        if (!gymRepository.existsById(gymId)) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Gym with id: " + gymId + " doesn't exist"
            );
        }

        List<Membership> memberships = membershipRepository.findMembershipsByGym_Id(gymId);

        List<MembershipResponseRecord> membershipRecords = memberships.stream()
                .map(membership -> membershipMapper.mapToMembershipResposne(membership))
                .toList();

        return new MembershipResponseListRecord(membershipRecords);
    }
}
