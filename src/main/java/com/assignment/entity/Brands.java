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


}
