package com.assignment.service;

import com.assignment.entity.Brands;

import java.util.List;

/**
 * Created by junaid on 30/11/2017.
 */

public interface IBrandService {

    List<Brands> getAllBrands();
    Brands getBrandsById(long brandId);
    boolean addBrands(Brands brand);
    void updateBrands(Brands brand);
    void deleteBrands(long brandId);

}
