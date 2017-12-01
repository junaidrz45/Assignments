package com.assignment.dao;

import com.assignment.entity.Brands;

import java.util.List;

/**
 * Created by junaid on 29/11/2017.
 */
public interface IBrandsDAO {
    List<Brands> getAllBrands();
    Brands getBrandsById(long brandId);
    void addBrands(Brands brand);
    void updateBrands(Brands brand);
    void deleteBrands(long brandId);
    boolean brandsExists(String title, String category);
}
