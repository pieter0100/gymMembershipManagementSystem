package com.gymmembershipmanagementsystem.backend.service;

import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipRecord;
import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipResponseRecord;

import java.util.List;

public interface MembershipService {
    MembershipResponseRecord addMembership(MembershipRecord membershipRecord);

    List<MembershipResponseRecord> getMemberships();
}
