package com.gymmembershipmanagementsystem.backend.controller;

import com.gymmembershipmanagementsystem.backend.dto.GymListRecord;
import com.gymmembershipmanagementsystem.backend.dto.GymRecord;
import com.gymmembershipmanagementsystem.backend.entity.Gym;
import com.gymmembershipmanagementsystem.backend.service.GymService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class GymController {

    private final GymService gymService;

    // create new gym
    @PostMapping("/gyms")
    public ResponseEntity addNewGym(@RequestBody GymRecord gymRecord) {
        Gym savedGym = gymService.addGym(gymRecord);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedGym);
    }

    // get all gyms
    @GetMapping("/gyms")
    public ResponseEntity getAllGyms() {
        List<Gym> allGyms = gymService.getGyms();

        return ResponseEntity.status(HttpStatus.OK).body(new GymListRecord(allGyms));
    }

}
