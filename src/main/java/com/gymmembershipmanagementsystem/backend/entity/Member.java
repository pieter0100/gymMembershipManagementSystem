package com.gymmembershipmanagementsystem.backend.entity;

import com.gymmembershipmanagementsystem.backend.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "membership_id", nullable = false)
    private Membership membership;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime membershipStartDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
}
