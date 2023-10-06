package com.api.pandilla.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Family")
@Data

public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String description;
    private String email;
    private String location;
    private String phone;
    private String typeOfAdoption; //adoptante o transito
    private Boolean contract;



}
