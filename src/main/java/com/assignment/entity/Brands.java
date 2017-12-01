package com.assignment.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by junaid on 27/11/2017.
 */

@Entity
@Table(name="Brands")
public class Brands implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="brand_id")
    private long brandid;

    @Column(name = "name")
    private String name;

    public long getBrandid() {
        return brandid;
    }

    public void setBrandid(long brandid) {
        this.brandid = brandid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
