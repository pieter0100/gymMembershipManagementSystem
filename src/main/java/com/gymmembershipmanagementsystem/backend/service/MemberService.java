package com.gymmembershipmanagementsystem.backend.service;

import com.gymmembershipmanagementsystem.backend.dto.member.MemberRequestRecord;
import com.gymmembershipmanagementsystem.backend.dto.member.MemberResponseDetailedListRecord;
import com.gymmembershipmanagementsystem.backend.dto.member.MemberResponseRecord;

public interface MemberService {

    // add new member
    MemberResponseRecord addNewMember(MemberRequestRecord memberRecord);

    // get all members
    MemberResponseDetailedListRecord getAllMembers();

    // change status to cancel
    MemberResponseRecord cancelMembership(Long id);

    // change status tu active (reactivate)
    MemberResponseRecord reactivateMembership(Long id);
}
