package com.assignment.controller;

import com.assignment.entity.WareHouse;
import com.assignment.service.IWareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by junaid on 02/12/2017.
 */
@Controller
@RequestMapping("wareHouse")
public class WareHouseController {

    @Autowired
    private IWareHouseService wareHouseService;


    @GetMapping("getbyId/{id}")
    public ResponseEntity<WareHouse> getWareHouseById(@PathVariable("id") long id) {
        WareHouse wareHouse = wareHouseService.getWareHouseById(id);
        return new ResponseEntity<WareHouse>(wareHouse, HttpStatus.OK);
    }

    @GetMapping("getall")
    public ResponseEntity<List<WareHouse>> getAllWareHouse(){
        List<WareHouse> brandsList = wareHouseService.getAllWareHouses();
        return new ResponseEntity<List<WareHouse>>(brandsList ,HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Void> addWareHouse(@RequestBody WareHouse wareHouse, UriComponentsBuilder builder) {
        boolean flag = wareHouseService.addWareHouse(wareHouse);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/wareHouse/{id}").buildAndExpand(wareHouse.getWarehouseid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<WareHouse> updateWareHouse(@RequestBody WareHouse wareHouse) {
        wareHouseService.updateWareHouse(wareHouse);
        return new ResponseEntity<WareHouse>(wareHouse, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteWareHouse(@PathVariable("id") long id) {
        wareHouseService.deleteWareHouse(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
