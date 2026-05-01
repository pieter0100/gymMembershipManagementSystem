package com.gymmembershipmanagementsystem.backend.controller;

import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipResponseListRecord;
import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipRecord;
import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipResponseRecord;
import com.gymmembershipmanagementsystem.backend.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MembershipController {

    private final MembershipService membershipService;

    @PostMapping("/memberships")
    public ResponseEntity addNewMembership(@RequestBody MembershipRecord membershipRecord) {
        MembershipResponseRecord savedMembership = membershipService.addMembership(membershipRecord);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedMembership);
    }

    @GetMapping("/memberships")
    public ResponseEntity getAllMemberships() {
        return ResponseEntity.status(HttpStatus.OK).body(new MembershipResponseListRecord(membershipService.getMemberships()));
    }
}
