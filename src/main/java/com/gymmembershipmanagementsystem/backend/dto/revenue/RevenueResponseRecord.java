package com.gymmembershipmanagementsystem.backend.dto.revenue;

import java.math.BigDecimal;

public record RevenueResponseRecord(
        String gymName,
        BigDecimal amount,
        String currency
) {
}
