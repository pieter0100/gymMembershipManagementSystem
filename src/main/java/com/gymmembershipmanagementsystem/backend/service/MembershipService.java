package com.gymmembershipmanagementsystem.backend.service;

import com.gymmembershipmanagementsystem.backend.dto.MembershipRecord;
import com.gymmembershipmanagementsystem.backend.dto.MembershipResponseRecord;
import com.gymmembershipmanagementsystem.backend.entity.Membership;

import java.util.List;

public interface MembershipService {
    MembershipResponseRecord addMembership(MembershipRecord membershipRecord);

    List<MembershipResponseRecord> getMemberships();
}
