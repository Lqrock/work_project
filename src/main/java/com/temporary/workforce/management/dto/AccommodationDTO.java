package com.temporary.workforce.management.dto;

import com.temporary.workforce.management.model.Employee;
import com.temporary.workforce.management.model.OwnershipType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AccommodationDTO {

    private int id; //

    private int houseNumber; //

    private int rentalPeriod;

    private int noticePeriod;

    private String ownersName; //

    private String ownersPhoneNumber; //

    private String email; //

    private OwnershipType ownershipType; //

    private Long ownersBankAccount; //

    private String province; //

    private String city; //

    private String address; //

    private Long postalCode;

    private List<FloorDTO> floors;

    private boolean hasInternet;

    private boolean hasParking;

    private List<UtilityDTO> utilities;

    private float rent;

    private float deposit;

    private List<FurnitureDTO> furniture;

//    private File contractFile; TODO learn

}
