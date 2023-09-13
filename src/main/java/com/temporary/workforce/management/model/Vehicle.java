package com.temporary.workforce.management.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty
    @Column(name = "model")
    private String model;

    @NotEmpty
    @Column(name = "brand")
    private String brand;

    @NotEmpty
    @Column(name = "plate_number")
    private String plateNumber;

    @Column(name = "vin")
    private Long vin;

    @Column(name = "mileage")
    private int mileage;

    @Enumerated(EnumType.STRING)
    @Column(name = "tire_type")
    private TireType tireType;

    @NotEmpty
    @Column(name = "insurance_type")
    private String insuranceType;

    @Enumerated(EnumType.STRING)
    @Column(name = "dkv_number")
    private DkvNumber dkvNumber;

    @NotEmpty
    @Column(name = "gps_number")
    private String gpsNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "owners_name")
    private VehicleOwner ownersName;

    @Column(name = "tuf_expiration_date")
    private LocalDate tufExpirationDate;

    @Column(name = "insurance_expiration_date")
    private LocalDate insuranceExpirationDate;

    @Column(name = "oil_change_indicator")
    private int oilChangeIndicator;

    @Column(name = "fuel_injector_change_indicator")
    private int fuelInjectorChangeIndicator;

    @Column(name = "timing_belt_change_indicator")
    private int timingBeltChangeIndicator;

    @Column(name = "ad_blue_change_indicator")
    private int adBlueChangeIndicator;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Employee> driversNameList;

//    @Column(name = "image")
//    private List images; // TODO LEARN THIS

    @Column(name = "fuel_injector_filter_change_required")
    private boolean fuelInjectorFilterChangeRequired;

    @Column(name = "anti_frost_change_required_change_required")
    private boolean antiFrostChangeRequired;

    @Column(name = "air_filter_change_required")
    private boolean airFilterChangeRequired;

    @Column(name = "inside_air_filter_change_required")
    private boolean insideAirFilterChangeRequired;

    @Column(name = "brake_fluid_change_required")
    private boolean brakeFluidChangeRequired;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project projectId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}




