package com.backend.test.model;
import javax.persistence.*;
@Entity
@Table(name = "regions")
public class Region {
    @Id
    @Column(name = "region_id")
    private int regionId;

    @Column(name = "region_name")
    private String regionName;
}
