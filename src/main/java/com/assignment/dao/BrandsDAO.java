package com.assignment.dao;

import com.assignment.entity.Brands;
import com.assignment.entity.Items;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by junaid on 29/11/2017.
 */
@Transactional
@Repository
public class BrandsDAO implements IBrandsDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Brands> getAllBrands() {
        String hql = "FROM Brands as brand ORDER BY brand.brandid";
        return (List<Brands>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Brands getBrandsById(long brandId) {
        return entityManager.find(Brands.class,brandId);
    }

    @Override
    public void addBrands(Brands brand) {
        entityManager.persist(brand);
    }

    @Override
    public void updateBrands(Brands brand) {
        Brands brands = getBrandsById(brand.getBrandid());
        brands.setName(brand.getName());
        entityManager.flush();
    }

    @Override
    public void deleteBrands(long brandId) {
        entityManager.remove(getBrandsById(brandId));
    }

    @Override
    public boolean brandsExists(String title, String category) {
        return false;
    }
}
