package com.gymmembershipmanagementsystem.backend.dto.gym;

public record GymResponseRecord(
        Long id,
        String name,
        String phoneNumber,
        String street,
        String city,
        String country,
        String postalCode
) {
}
