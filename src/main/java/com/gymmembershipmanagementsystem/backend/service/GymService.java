package com.gymmembershipmanagementsystem.backend.service;

import com.gymmembershipmanagementsystem.backend.dto.gym.GymRecord;
import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipResponseListRecord;
import com.gymmembershipmanagementsystem.backend.entity.Gym;

import java.util.List;

public interface GymService {

    // creates new gym
    Gym addGym(GymRecord gymRecord);

    // get all gyms
    List<Gym> getGyms();

    // get all memberships for given gym
    MembershipResponseListRecord getAllMembershipPlansFromGym(Long gymId);
}
