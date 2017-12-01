package com.assignment.service;

import com.assignment.dao.IBrandsDAO;
import com.assignment.entity.Brands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by junaid on 30/11/2017.
 */
@Service
public class BrandService implements IBrandService {

    @Autowired
    IBrandsDAO brandsDAO;

    @Override
    public List<Brands> getAllBrandss() {
        return brandsDAO.getAllBrands();
    }

    @Override
    public Brands getBrandsById(long articleId) {
        return brandsDAO.getBrandsById(articleId);
    }

    @Override
    public boolean addBrands(Brands brands) {
        brandsDAO.addBrands(brands);
        return true;
    }

    @Override
    public void updateBrands(Brands brands) {
        brandsDAO.updateBrands(brands);
    }

    @Override
    public void deleteBrands(long brandsId) {
        brandsDAO.deleteBrands(brandsId);
    }
}
