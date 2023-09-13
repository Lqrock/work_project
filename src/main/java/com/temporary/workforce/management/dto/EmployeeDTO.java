package com.temporary.workforce.management.dto;

import com.temporary.workforce.management.model.Gender;
import com.temporary.workforce.management.model.MaritalStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class EmployeeDTO {

    private int id;

    private String firstName;

    private String lastName;

    private int identityNumber;

    private Gender gender;

    private MaritalStatus maritalStatus;

    private String nationality;

    private String citizenshipCountry;

    private LocalDate dateOfBirth;

    private String placeOfBirth;

    private String address;

    private String phoneNumber;

    private String email;

    private String bankName;

    private Long bankAccountNumber;

    private boolean hasDriversLicense; //

    private LocalDate startingDate; //

    private LocalDate finishingDate; //

    private List<ProjectDTO> projects;

//    private List<VehicleDTO> vehicles;

//    private File contractFile;

    private double salaryPerHour;

    private String contractType;

//    private VehicleDTO vehicle;

    private JobPositionDTO jobPosition;

    private AccommodationDTO accommodation; //

    private List<TimeSheetDTO> timeSheetList;

    private List<LanguageDTO> spokenLanguages; //

}
