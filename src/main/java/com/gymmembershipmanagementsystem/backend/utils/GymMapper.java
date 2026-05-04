package com.gymmembershipmanagementsystem.backend.utils;

import com.gymmembershipmanagementsystem.backend.dto.gym.GymResponseRecord;
import com.gymmembershipmanagementsystem.backend.entity.Gym;
import org.springframework.stereotype.Component;

@Component
public class GymMapper {
    public GymResponseRecord mapToGymResponseRecord(Gym gym) {
        return new GymResponseRecord(
                gym.getId(),
                gym.getName(),
                gym.getPhoneNumber(),
                gym.getStreet(),
                gym.getCity(),
                gym.getCountry(),
                gym.getPostalCode()
        );
    }
}
