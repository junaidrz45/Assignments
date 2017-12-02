package com.assignment.dao;

import com.assignment.entity.Article;
import com.assignment.entity.Items;

import java.util.List;

/**
 * Created by junaid on 29/11/2017.
 */

public interface IItemsDAO {

    List<Items> getAllItems();
    List<Items> getAllItemsByCountry(String countryName);
    Items getItemsById(long ItemsId);
    void addItems(Items items);
    void updateItems(Items items);
    void deleteItems(long itemsId);
    boolean itemExists(String name);
}
