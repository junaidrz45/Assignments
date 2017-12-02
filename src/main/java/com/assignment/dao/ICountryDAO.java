package com.assignment.dao;

import com.assignment.entity.Country;
import java.util.List;

/**
 * Created by junaid on 01/12/2017.
 */

public interface ICountryDAO {
    List<Country> getAllCountries();
    Country getCountryById(long countryId);
    void addCountry(Country country);
    void updateCountry(Country country);
    void deleteCountry(long countryId);
    boolean countryExists(String name);
}
