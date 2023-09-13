package com.temporary.workforce.management.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "furniture")
public class Furniture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}


