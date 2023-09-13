package com.temporary.workforce.management.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "utility")
public class Utility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;
}
