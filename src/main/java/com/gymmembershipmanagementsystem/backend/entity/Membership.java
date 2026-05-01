package com.gymmembershipmanagementsystem.backend.entity;

import com.gymmembershipmanagementsystem.backend.enums.MembershipPlanType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "gym_id", nullable = false)
    private Gym gym;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MembershipPlanType membershipPlanType;

    @Column(precision = 8, scale = 2, nullable = false)
    private BigDecimal monthlyPrice;

    @Column(length = 3, nullable = false)
    private String currencyCode;

    @Column(nullable = false)
    private int durationMonths;

    @Column(nullable = false)
    private int maximumMembers;

    @OneToMany(mappedBy = "membership")
    private List<Member> members = new ArrayList<>();
}
