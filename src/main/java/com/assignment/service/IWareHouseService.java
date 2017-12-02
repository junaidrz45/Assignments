package com.assignment.service;

import com.assignment.entity.WareHouse;

import java.util.List;

/**
 * Created by junaid on 02/12/2017.
 */
public interface IWareHouseService {

    List<WareHouse> getAllWareHouses();
    WareHouse getWareHouseById(long wareHouseId);
    boolean addWareHouse(WareHouse wareHouse);
    void updateWareHouse(WareHouse wareHouse);
    void deleteWareHouse(long wareHouseId);
}
