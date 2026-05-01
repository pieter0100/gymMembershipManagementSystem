package com.gymmembershipmanagementsystem.backend.dto;

import com.gymmembershipmanagementsystem.backend.entity.Gym;

import java.util.List;

public record GymListRecord(List<Gym> gymsList) {
}
