package com.gymmembershipmanagementsystem.backend.dto.membership;

import com.gymmembershipmanagementsystem.backend.enums.MembershipPlanType;

import java.math.BigDecimal;

public record MembershipResponseRecord(
        Long id,
        Long gymId,
        String name,
        MembershipPlanType membershipPlanType,
        BigDecimal monthlyPrice,
        String currencyCode,
        int durationMonths,
        int maximumMembers
) {
}
