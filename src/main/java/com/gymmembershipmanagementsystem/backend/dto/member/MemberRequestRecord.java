package com.gymmembershipmanagementsystem.backend.dto.member;

import java.time.LocalDateTime;

public record MemberRequestRecord(
        Long membershipId,
        String firstName,
        String lastName,
        String email,
        LocalDateTime membershipStartDate
) {
}
