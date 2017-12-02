package com.assignment.service;

import com.assignment.dao.ICountryDAO;
import com.assignment.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by junaid on 02/12/2017.
 */

@Service
public class CountryService implements ICountryService {

    @Autowired
    ICountryDAO countryDAO;

    @Override
    public List<Country> getAllCountry() {
        return countryDAO.getAllCountries();
    }

    @Override
    public Country getCountryById(long countryId) {
        return countryDAO.getCountryById(countryId);
    }

    @Override
    public boolean addCountry(Country country) {
        if(countryDAO.countryExists(country.getName())){
            return false;
        }else{
            countryDAO.addCountry(country);
            return true;
        }
    }

    @Override
    public void updateCountry(Country country) {
        countryDAO.updateCountry(country);
    }

    @Override
    public void deleteCountry(long countryId) {
        countryDAO.deleteCountry(countryId);
    }
}
