package com.gymmembershipmanagementsystem.backend.dto.member;

import com.gymmembershipmanagementsystem.backend.enums.Status;

import java.time.LocalDateTime;

public record MemberRecord(
        Long membershipId,
        String firstName,
        String lastName,
        String email,
        LocalDateTime membershipStartDate
) {
}
