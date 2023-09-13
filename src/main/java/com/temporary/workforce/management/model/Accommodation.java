package com.temporary.workforce.management.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "accommodation")
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "house_number")
    private int houseNumber;

    @Column(name = "rental_period")
    private int rentalPeriod;

    @Column(name = "notice_period")
    private int noticePeriod;

    @Column(name = "owners_bank_account")
    private Long ownersBankAccount;

    @Column(name = "postal_code")
    private Long postalCode;

    @Column(name = "rent")
    private float rent;

    @Column(name = "deposit")
    private float deposit;

    @Column(name = "owners_name")
    private String ownersName;

    @Column(name = "owners_phone_number")
    private String ownersPhoneNumber;

    @Email(regexp = ".+@.+\\..+")
    @Column(name = "owners_email")
    private String email;

    @Column(name = "province")
    private String province;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "has_internet")
    private boolean hasInternet;

    @Column(name = "has_parking")
    private boolean hasParking;

    @Enumerated(EnumType.STRING)
    @Column(name = "ownership_type")
    private OwnershipType ownershipType;

    @OneToMany(mappedBy = "accommodation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Floor> floors;

    @OneToMany(mappedBy = "accommodation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Utility> utilities;

    @OneToMany(mappedBy = "accommodation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Furniture> furniture;

//    @Column(name = "contract_file")
//    private File contractFile; TODO

}
