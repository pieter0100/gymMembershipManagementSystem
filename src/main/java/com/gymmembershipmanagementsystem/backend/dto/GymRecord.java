package com.gymmembershipmanagementsystem.backend.dto;

public record GymRecord(
        String name,
        String phoneNumber,
        String street,
        String city,
        String country,
        String postalCode
) {
}
