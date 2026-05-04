package com.gymmembershipmanagementsystem.backend.controller;

import com.gymmembershipmanagementsystem.backend.dto.revenue.RevenueListResponseRecord;
import com.gymmembershipmanagementsystem.backend.service.GymService;
import com.gymmembershipmanagementsystem.backend.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RevenueController {
    private final GymService gymService;

    @GetMapping("/revenue")
    public ResponseEntity getRevenue() {
        return ResponseEntity.status(HttpStatus.OK).body(new RevenueListResponseRecord(gymService.getRevenue()));
    }
}
