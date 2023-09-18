package com.temporary.workforce.management.dto;

import com.temporary.workforce.management.model.Brand;
import com.temporary.workforce.management.model.DkvNumber;
import com.temporary.workforce.management.model.TireType;
import com.temporary.workforce.management.model.VehicleOwner;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VehicleDTO {

    private int id;

    private Brand brand;

    private String model;

    private VehicleOwner ownersName;

    private String plateNumber;

    private Long vin;

    private int mileage;

    private TireType tireType;

    private String insuranceType;

    private DkvNumber dkvNumber;

    private String gpsNumber;

    private LocalDate tufExpirationDate;

    private LocalDate insuranceExpirationDate;

    private int oilChangeIndicator;

    private int fuelInjectorChangeIndicator;

    private int timingBeltChangeIndicator;

    private int adBlueChangeIndicator;

//    private List images; // TODO LEARN THIS

    private boolean fuelInjectorFilterChangeRequired;

    private boolean antiFrostChangeRequired;

    private boolean airFilterChangeRequired;

    private boolean insideAirFilterChangeRequired;

    private boolean brakeFluidChangeRequired;

    private EmployeeDTO employee;
}
