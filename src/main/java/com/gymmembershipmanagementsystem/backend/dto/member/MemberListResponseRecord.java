package com.gymmembershipmanagementsystem.backend.dto.member;

import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipResponseRecord;

import java.util.List;

public record MemberListResponseRecord(List<MemberResponseRecord> membersList) {
}
