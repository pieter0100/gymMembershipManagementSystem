package com.gymmembershipmanagementsystem.backend.controller;

import com.gymmembershipmanagementsystem.backend.dto.member.MemberListResponseRecord;
import com.gymmembershipmanagementsystem.backend.dto.member.MemberRecord;
import com.gymmembershipmanagementsystem.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity addMember(@RequestBody MemberRecord memberRecord) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.addNewMember(memberRecord));
    }

    @GetMapping("/members")
    public ResponseEntity getAllMembers() {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.getAllMembers());
    }
}
