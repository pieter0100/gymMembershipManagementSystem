package com.gymmembershipmanagementsystem.backend.service;

import com.gymmembershipmanagementsystem.backend.dto.GymRecord;
import com.gymmembershipmanagementsystem.backend.dto.MembershipResponseListRecord;
import com.gymmembershipmanagementsystem.backend.entity.Gym;
import com.gymmembershipmanagementsystem.backend.entity.Membership;

import java.util.List;

public interface GymService {

    // creates new gym
    Gym addGym(GymRecord gymRecord);

    // get all gyms
    List<Gym> getGyms();

    // get all memberships for given gym
    MembershipResponseListRecord getAllMembershipPlansFromGym(Long gymId);
}
