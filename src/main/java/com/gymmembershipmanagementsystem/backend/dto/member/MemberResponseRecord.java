package com.gymmembershipmanagementsystem.backend.dto.member;

import com.gymmembershipmanagementsystem.backend.enums.Status;

import java.time.LocalDateTime;

public record MemberResponseRecord(
        Long id,
        Long membershipId,
        String firstName,
        String lastName,
        String email,
        LocalDateTime membershipStartDate,
        Status status
) {
}
