package com.gymmembershipmanagementsystem.backend.config;

import com.gymmembershipmanagementsystem.backend.dto.gym.GymRecord;
import com.gymmembershipmanagementsystem.backend.dto.member.MemberRequestRecord;
import com.gymmembershipmanagementsystem.backend.dto.member.MemberResponseDetailedRecord;
import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipRequestRecord;
import com.gymmembershipmanagementsystem.backend.dto.membership.MembershipResponseRecord;
import com.gymmembershipmanagementsystem.backend.entity.Gym;
import com.gymmembershipmanagementsystem.backend.entity.Member;
import com.gymmembershipmanagementsystem.backend.entity.Membership;
import com.gymmembershipmanagementsystem.backend.enums.MembershipPlanType;
import com.gymmembershipmanagementsystem.backend.enums.Status;
import com.gymmembershipmanagementsystem.backend.repository.GymRepository;
import com.gymmembershipmanagementsystem.backend.repository.MemberRepository;
import com.gymmembershipmanagementsystem.backend.repository.MembershipRepository;
import com.gymmembershipmanagementsystem.backend.service.GymService;
import com.gymmembershipmanagementsystem.backend.service.MemberService;
import com.gymmembershipmanagementsystem.backend.service.MembershipService;
import com.gymmembershipmanagementsystem.backend.utils.MembershipMapper;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Configuration
public class PopulateDatabase {

    @Bean
    CommandLineRunner loadTestData(
            GymService gymService,
            MembershipService membershipService,
            MemberService memberService,
            MembershipMapper membershipMapper
    ) {
        return args -> {
            // setting seed to have always the same values for easier testing
            Random random = new Random(1);
            Faker faker = new Faker(new Locale("pl"), random);

            ArrayList<Gym> gyms = new ArrayList<>(5);
            // create gyms
            for (int i = 0; i < 5; i++) {
                gyms.add(i, gymService.addGym(
                        new GymRecord(
                                "Super Fit " + faker.address().cityName(),
                                faker.address().city(),
                                faker.address().streetAddress(),
                                faker.phoneNumber().cellPhone(),
                                "Polska",
                                faker.address().zipCode()
                        )
                ));
            }

            // create memberships
            List<MembershipResponseRecord> memberships = new ArrayList<>(50);

            for (int i = 0; i < 50; i++) {
                MembershipPlanType randomPlanType = faker.options().option(MembershipPlanType.values());
                String randomName = "Karnet " + randomPlanType + " - " + faker.commerce().promotionCode();

                MembershipRequestRecord requestRecord = new MembershipRequestRecord(
                        gyms.get(i % 5).getId(),
                        randomName,
                        randomPlanType,
                        BigDecimal.valueOf(faker.number().randomDouble(2, 50, 350)),
                        faker.currency().code(),
                        faker.options().option(1, 3, 6, 12, 24),
                        faker.number().numberBetween(5, 50)
                );

                MembershipResponseRecord response = membershipService.addMembership(requestRecord);

                memberships.add(response);
            }

            for (int i = 0; i < 500; i++) {
                MembershipResponseRecord randomMembership = memberships.get(faker.number().numberBetween(0, memberships.size()));

                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();
                String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "." + faker.number().numberBetween(1, 9999) + "@example.com";

                MemberRequestRecord requestRecord = new MemberRequestRecord(
                        randomMembership.id(),
                        firstName,
                        lastName,
                        email
                );

                try{
                    memberService.addNewMember(requestRecord);

                } catch (ResponseStatusException rse) {
                    System.err.println(
                            "Maximum capacity of members, doesn't" +
                                    " matter we create next members, message: " + rse.getMessage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
