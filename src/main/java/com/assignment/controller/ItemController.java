package com.assignment.controller;

import com.assignment.entity.Items;
import com.assignment.entity.WareHouse;
import com.assignment.service.IitemService;
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
@RequestMapping("product")
public class ItemController {

    @Autowired
    IitemService itemService;

    @GetMapping("getbyId/{id}")
    public ResponseEntity<Items> getItemsById(@PathVariable("id") long id) {
        Items item = itemService.getItemsById(id);
        return new ResponseEntity<Items>(item, HttpStatus.OK);
    }

    @GetMapping("getall")
    public ResponseEntity<List<Items>> getAllItems(){
        List<Items> itemList = itemService.getAllItems();
        return new ResponseEntity<List<Items>>(itemList ,HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Void> addItem(@RequestBody Items item, UriComponentsBuilder builder) {
        boolean flag = itemService.addItems(item);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/getbyId/{id}").buildAndExpand(item.getItemid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<Items> updateItems(@RequestBody Items item) {
        itemService.updateItems(item);
        return new ResponseEntity<Items>(item, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteItems(@PathVariable("id") long id) {
        itemService.deleteItems(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


}
