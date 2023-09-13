package com.temporary.workforce.management.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "identity_number")
    private int identityNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status")
    private MaritalStatus maritalStatus;

    @NotEmpty
    @Column(name = "nationality")
    private String nationality;

    @NotEmpty
    @Column(name = "citizenship_country")
    private String citizenshipCountry;

    @NotNull
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @NotEmpty
    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @NotEmpty
    @Column(name = "address")
    private String address;

    @NotEmpty
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotEmpty
    @Email(regexp = ".+@.+\\..+")
    @Column(name = "email")
    private String email;

    @NotEmpty
    @Column(name = "bank_name")
    private String bankName;

    @NotNull
    @Column(name = "bank_account_number")
    private Long bankAccountNumber;

    @NotNull
    @Column(name = "has_drivers_license")
    private boolean hasDriversLicense;

    @NotNull
    @Column(name = "starting_date")
    private LocalDate startingDate;

    @NotNull
    @Column(name = "finishing_date")
    private LocalDate finishingDate;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Project> projects;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private List<Vehicle> vehicles;

//    @Column(name = "contract_file")
//    private File contractFile;

    @Column(name = "salary_per_hour")
    private double salaryPerHour;

    @NotEmpty
    @Column(name = "contract_type")
    private String contractType;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<TimeSheet> timeSheetList;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Language> spokenLanguages;

}
