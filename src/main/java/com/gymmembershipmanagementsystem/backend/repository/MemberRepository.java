package com.gymmembershipmanagementsystem.backend.repository;

import com.gymmembershipmanagementsystem.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    long countMembersByMembership_Id(Long membershipId);

    @Query("SELECT m FROM Member m LEFT JOIN FETCH m.membership mem LEFT JOIN FETCH mem.gym")
    List<Member> findAllWithDetails();
}
