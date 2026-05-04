package com.gymmembershipmanagementsystem.backend.controller;

import com.gymmembershipmanagementsystem.backend.dto.gym.GymListRecord;
import com.gymmembershipmanagementsystem.backend.dto.gym.GymRequestRecord;
import com.gymmembershipmanagementsystem.backend.entity.Gym;
import com.gymmembershipmanagementsystem.backend.service.GymService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class GymController {

    private final GymService gymService;

    // create new gym
    @PostMapping("/gyms")
    public ResponseEntity addNewGym(@RequestBody GymRequestRecord gymRecord) {
        Gym savedGym = gymService.addGym(gymRecord);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedGym);
    }

    // get all gyms
    @GetMapping("/gyms")
    public ResponseEntity getAllGyms() {
        return ResponseEntity.status(HttpStatus.OK).body(new GymListRecord(gymService.getGyms()));
    }

    // get all memberships for particular gym
    @GetMapping("/gyms/{gymId}/memberships")
    public ResponseEntity getAllMembershipPlansForGivenGym(@PathVariable Long gymId) {

        return ResponseEntity.status(HttpStatus.OK).body(
                gymService.getAllMembershipPlansFromGym(gymId)
        );
    }

}
