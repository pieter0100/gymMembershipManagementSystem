package com.gymmembershipmanagementsystem.backend.dto.gym;

import com.gymmembershipmanagementsystem.backend.entity.Gym;

import java.util.List;

public record GymListRecord(List<GymResponseRecord> gymsList) {
}
