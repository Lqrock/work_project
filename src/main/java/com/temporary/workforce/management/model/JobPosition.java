package com.temporary.workforce.management.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "job_position")
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "jobPositions")
    private List<Project> projects;
}


