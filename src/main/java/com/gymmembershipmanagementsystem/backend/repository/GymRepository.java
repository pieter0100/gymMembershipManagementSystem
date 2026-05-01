package com.gymmembershipmanagementsystem.backend.repository;

import com.gymmembershipmanagementsystem.backend.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Gym, Long> {
    boolean findGymByName(String name);

    boolean existsGymByName(String name);
}
