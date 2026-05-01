package com.gymmembershipmanagementsystem.backend.repository;

import com.gymmembershipmanagementsystem.backend.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
}
