package com.api.pandilla.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Families")
@Data

public class Families {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String description;
    private String email;
    private String location;
    private String phone;
    private Boolean contract;

}
