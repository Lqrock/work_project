package com.temporary.workforce.management.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "email")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @javax.validation.constraints.Email(regexp = ".+@.+\\..+")
    @Column(name = "email_address")
    private String emailAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Project project;
}
