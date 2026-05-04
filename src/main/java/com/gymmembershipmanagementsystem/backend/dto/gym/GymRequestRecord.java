package com.gymmembershipmanagementsystem.backend.dto.gym;

public record GymRequestRecord(
        String name,
        String phoneNumber,
        String street,
        String city,
        String country,
        String postalCode
) {
}
