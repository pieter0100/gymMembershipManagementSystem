package com.gymmembershipmanagementsystem.backend.repository;

import com.gymmembershipmanagementsystem.backend.dto.revenue.RevenueResponseRecord;
import com.gymmembershipmanagementsystem.backend.entity.Gym;
import com.gymmembershipmanagementsystem.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GymRepository extends JpaRepository<Gym, Long> {
    boolean findGymByName(String name);

    boolean existsGymByName(String name);

    @Query("""
        SELECT new com.gymmembershipmanagementsystem.backend.dto.revenue.RevenueResponseRecord(
            gyms.name, SUM(memberships.monthlyPrice), memberships.currencyCode
        )
        FROM Gym gyms
        JOIN gyms.memberships memberships
        JOIN memberships.members members
        WHERE members.status = 'ACTIVE'
        GROUP BY gyms.name, memberships.currencyCode
        ORDER BY SUM(memberships.monthlyPrice) DESC
    """)
    List<RevenueResponseRecord> calculateRevenuePerGym();
}
