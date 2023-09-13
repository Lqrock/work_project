package com.temporary.workforce.management.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Column(name = "code")
    private String code;

    @NotEmpty
    @Column(name = "address")
    private String address;

    @Column(name = "starting_date")
    private LocalDate startingDate;

    @Column(name = "finishing_date")
    private LocalDate finishingDate;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PhoneNumber> phoneNumbers;


    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Email> emails;

    @Column(name = "maximum_employees_number")
    private int maximumEmployeesNumber;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "project_job_position", joinColumns = {@JoinColumn(name = "project_id")}, inverseJoinColumns = {@JoinColumn(name = "job_position_id")})
    private List<JobPosition> jobPositions;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
