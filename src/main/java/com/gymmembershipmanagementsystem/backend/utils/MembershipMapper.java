package com.gymmembershipmanagementsystem.backend.utils;

import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipResponseRecord;
import com.gymmembershipmanagementsystem.backend.entity.Membership;
import org.springframework.stereotype.Component;

@Component
public class MembershipMapper {
    public MembershipResponseRecord mapToMembershipResposne(Membership membership) {
        return new MembershipResponseRecord(
                membership.getId(),
                membership.getGym().getId(),
                membership.getName(),
                membership.getMembershipPlanType(),
                membership.getMonthlyPrice(),
                membership.getCurrencyCode(),
                membership.getDurationMonths(),
                membership.getMaximumMembers()
        );
    }
}
