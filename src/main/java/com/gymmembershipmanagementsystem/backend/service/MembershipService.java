package com.gymmembershipmanagementsystem.backend.service;

import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipRequestRecord;
import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipResponseRecord;

import java.util.List;

public interface MembershipService {
    MembershipResponseRecord addMembership(MembershipRequestRecord membershipRecord);

    List<MembershipResponseRecord> getMemberships();
}
