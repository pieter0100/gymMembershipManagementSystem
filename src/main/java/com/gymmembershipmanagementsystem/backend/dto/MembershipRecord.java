package com.gymmembershipmanagementsystem.backend.dto;

import com.gymmembershipmanagementsystem.backend.enums.MembershipPlanType;

import java.math.BigDecimal;

public record MembershipRecord(
        Long gymId,
        String name,
        MembershipPlanType membershipPlanType,
        BigDecimal monthlyPrice,
        String currencyCode,
        int durationMonths,
        int maximumMembers
) {
}
