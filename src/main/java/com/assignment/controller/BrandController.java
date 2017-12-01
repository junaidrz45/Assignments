package com.assignment.controller;

import com.assignment.entity.Article;
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
@RequestMapping("product")
public class BrandController {

    @Autowired
    private IBrandService brandService;


    @GetMapping("brand/{id}")
    public ResponseEntity<Brands> getBrandsById(@PathVariable("id") long id) {
        Brands brands = brandService.getBrandsById(id);
        return new ResponseEntity<Brands>(brands, HttpStatus.OK);
    }

    @GetMapping("brand")
    public ResponseEntity<List<Brands>> getAllBrands(){
        List<Brands> brandsList = brandService.getAllBrandss();
        return new ResponseEntity<List<Brands>>(brandsList ,HttpStatus.OK);
    }

    @PostMapping("brand")
    public ResponseEntity<Void> addArticle(@RequestBody Brands brand, UriComponentsBuilder builder) {
        boolean flag = brandService.addBrands(brand);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/brand/{id}").buildAndExpand(brand.getBrandid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("brand")
    public ResponseEntity<Brands> updateArticle(@RequestBody Brands brand) {
        brandService.updateBrands(brand);
        return new ResponseEntity<Brands>(brand, HttpStatus.OK);
    }

    @DeleteMapping("brand/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") long id) {
        brandService.deleteBrands(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }



}
