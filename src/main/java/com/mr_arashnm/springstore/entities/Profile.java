package com.mr_arashnm.springstore.entities;


import javax.annotation.processing.Generated;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "profile")
public class Profile {
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "bio")
    private String bio;
    @Column(nmae = "phone_number")
    private String PhoneNumber;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "loyalty_points")
    private Integer loyaltyPoints;

    @OmeToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @MapsId
    @ToString.Exclude
    private User user;
}