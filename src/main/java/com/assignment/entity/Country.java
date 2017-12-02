package com.assignment.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by junaid on 27/11/2017.
 */
@Entity
@Table(name="country")
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="country_id")
    private long countryId;

    @Column(name="name")
    private String name;

    public long getCountryId(){
        return this.countryId;
    }

    public void setCountryId(long countryid) {
        this.countryId = countryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
