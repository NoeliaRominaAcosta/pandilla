package com.api.pandilla.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
@Data
public class Illness {
    private Long id;
    private String name;
    private String description;
    private String treatment;
    private Date diagnosingDate;

}
