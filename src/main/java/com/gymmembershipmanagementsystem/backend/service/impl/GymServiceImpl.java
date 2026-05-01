package com.gymmembershipmanagementsystem.backend.service.impl;

import com.gymmembershipmanagementsystem.backend.dto.GymRecord;
import com.gymmembershipmanagementsystem.backend.entity.Gym;
import com.gymmembershipmanagementsystem.backend.repository.GymRepository;
import com.gymmembershipmanagementsystem.backend.service.GymService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class GymServiceImpl implements GymService {

    private final GymRepository gymRepository;

    GymServiceImpl(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }

    // creates new gym
    @Override
    public Gym addGym(GymRecord gymRecord) {
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
}
