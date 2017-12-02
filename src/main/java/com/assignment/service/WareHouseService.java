package com.assignment.service;

import com.assignment.dao.IWareHouseDAO;
import com.assignment.entity.WareHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by junaid on 02/12/2017.
 */
@Service
public class WareHouseService implements IWareHouseService {

    @Autowired
    IWareHouseDAO wareHouseDAO;

    @Override
    public List<WareHouse> getAllWareHouses() {
        return wareHouseDAO.getAllWareHouse();
    }

    @Override
    public WareHouse getWareHouseById(long wareHouseId) {
        return wareHouseDAO.getWareHouseById(wareHouseId);
    }

    @Override
    public boolean addWareHouse(WareHouse wareHouse) {
        if(wareHouseDAO.wareHousesExists(wareHouse.getName())){
            return false;
        }else{
            wareHouseDAO.addWareHouse(wareHouse);
            return true;
        }
    }

    @Override
    public void updateWareHouse(WareHouse wareHouse) {
        wareHouseDAO.updateWareHouse(wareHouse);
    }

    @Override
    public void deleteWareHouse(long wareHouseId) {
        wareHouseDAO.deleteWareHouse(wareHouseId);
    }
}
