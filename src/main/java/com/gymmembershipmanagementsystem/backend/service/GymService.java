package com.gymmembershipmanagementsystem.backend.service;

import com.gymmembershipmanagementsystem.backend.dto.gym.GymRequestRecord;
import com.gymmembershipmanagementsystem.backend.dto.gym.GymResponseRecord;
import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipResponseListRecord;
import com.gymmembershipmanagementsystem.backend.entity.Gym;

import java.util.List;

public interface GymService {

    // creates new gym
    Gym addGym(GymRequestRecord gymRecord);

    // get all gyms
    List<GymResponseRecord> getGyms();

    // get all memberships for given gym
    MembershipResponseListRecord getAllMembershipPlansFromGym(Long gymId);
}
