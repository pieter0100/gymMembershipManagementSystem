package com.gymmembershipmanagementsystem.backend.repository;

import com.gymmembershipmanagementsystem.backend.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
    List<Membership> findMembershipsByGym_Id(Long gymId);
}
