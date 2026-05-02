package com.gymmembershipmanagementsystem.backend.dto.member;

import com.gymmembershipmanagementsystem.backend.enums.Status;

import java.time.LocalDateTime;

public record MemberResponseDetailedRecord(
        Long id,
        Long membershipId,
        String membershipName,
        String gymName,
        String firstName,
        String lastName,
        String email,
        LocalDateTime membershipStartDate,
        Status status
) {
}
