package com.assignment.service;

import com.assignment.entity.Items;

import java.util.List;

/**
 * Created by junaid on 02/12/2017.
 */
public interface IitemService {

    List<Items> getAllItems();
    List<Items> getAllItemsByCountry(String countryName);
    Items getItemsById(long itemId);
    boolean addItems(Items item);
    void updateItems(Items item);
    void deleteItems(long itemId);

}
