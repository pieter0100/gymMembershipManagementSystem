package com.gymmembershipmanagementsystem.backend.repository;

import com.gymmembershipmanagementsystem.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    long countMembersByMembership_Id(Long membershipId);
}
