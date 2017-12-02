package com.assignment.dao;

import com.assignment.entity.Brands;
import com.assignment.entity.Country;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by junaid on 01/12/2017.
 */
public class CountryDAO implements ICountryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Country> getAllCountries() {
        String hql = "FROM Country as country ORDER BY country.countryId";
        return (List<Country>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Country getCountryById(long countryId) {
        return entityManager.find(Country.class,countryId);
    }

    @Override
    public void addCountry(Country country) {
        entityManager.persist(country);
    }

    @Override
    public void updateCountry(Country country) {
        Country contry = getCountryById(country.getCountryId());
        contry.setCountryId(country.getCountryId());
        contry.setName(country.getName());
        entityManager.flush();
    }

    @Override
    public void deleteCountry(long countryId) {
        entityManager.remove(getCountryById(countryId));
    }

    @Override
    public boolean countryExists(String name) {
        String hql = "FROM Country as contry WHERE contry.name = ? ";
        int count = entityManager.createQuery(hql).setParameter(1, name).getResultList().size();
        return count > 0 ? true : false;
    }
}
