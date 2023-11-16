package com.backend.test.model;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(name = "regions")
@NoArgsConstructor
public class Region {
    @Id
    @Column(name = "region_id")
    private int regionId;

    @Column(name = "region_name")
    private String regionName;
}
