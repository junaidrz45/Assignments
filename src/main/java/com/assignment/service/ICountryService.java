package com.assignment.service;

import com.assignment.entity.Country;

import java.util.List;

/**
 * Created by junaid on 01/12/2017.
 */
public interface ICountryService {

    List<Country> getAllCountry();
    Country getCountryById(long countryId);
    boolean addCountry(Country country);
    void updateCountry(Country country);
    void deleteCountry(long countryId);

}
