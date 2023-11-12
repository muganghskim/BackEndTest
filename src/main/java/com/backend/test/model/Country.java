package com.backend.test.model;

import javax.persistence.*;
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @Column(name = "country_id")
    private String countryId;

    @Column(name = "country_name")
    private String countryName;

    @ManyToOne
    @JoinColumn(name="region_id", nullable=false)
    private Region region;
}
