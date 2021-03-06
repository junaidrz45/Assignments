package com.assignment.controller;


import com.assignment.entity.Brands;
import com.assignment.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by junaid on 01/12/2017.
 */

@Controller
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private IBrandService brandService;


    @GetMapping("get/{id}")
    public ResponseEntity<Brands> getBrandsById(@PathVariable("id") long id) {
        Brands brands = brandService.getBrandsById(id);
        return new ResponseEntity<Brands>(brands, HttpStatus.OK);
    }

    @GetMapping("getall")
    public ResponseEntity<List<Brands>> getAllBrands(){
        List<Brands> brandsList = brandService.getAllBrands();
        return new ResponseEntity<List<Brands>>(brandsList ,HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Void> addBrand(@RequestBody Brands brand, UriComponentsBuilder builder) {
        boolean flag = brandService.addBrands(brand);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/brand/{id}").buildAndExpand(brand.getBrandid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<Brands> updateBrand(@RequestBody Brands brand) {
        brandService.updateBrands(brand);
        return new ResponseEntity<Brands>(brand, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable("id") long id) {
        brandService.deleteBrands(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }



}
