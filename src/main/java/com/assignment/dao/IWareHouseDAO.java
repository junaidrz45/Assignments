package com.assignment.dao;

import com.assignment.entity.Brands;
import com.assignment.entity.WareHouse;

import java.util.List;

/**
 * Created by junaid on 29/11/2017.
 */
public interface IWareHouseDAO {
    List<WareHouse> getAllWareHouse();
    WareHouse getWareHouseById(long wareHouseId);
    void addWareHouse(WareHouse wareHouse);
    void updateWareHouse(WareHouse wareHouse);
    void deleteWareHouse(long wareHouseId);
    boolean wareHousesExists(String title, String category);
}
