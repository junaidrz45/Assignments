package com.assignment.service;

import com.assignment.entity.Brands;

import java.util.List;

/**
 * Created by junaid on 30/11/2017.
 */

public interface IBrandService {

    List<Brands> getAllBrandss();
    Brands getBrandsById(long articleId);
    boolean addBrands(Brands article);
    void updateBrands(Brands article);
    void deleteBrands(long articleId);

}
