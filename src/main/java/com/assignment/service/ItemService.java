package com.assignment.service;

import com.assignment.dao.IItemsDAO;
import com.assignment.entity.Items;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by junaid on 02/12/2017.
 */

public class ItemService implements IitemService{

    @Autowired
    IItemsDAO itemsDAO;

    @Override
    public List<Items> getAllItems() {
        return itemsDAO.getAllItemss();
    }

    @Override
    public Items getItemsById(long itemId) {
        return itemsDAO.getItemsById(itemId);
    }

    @Override
    public boolean addItems(Items item) {
        if(itemsDAO.itemExists(item.getName())){
            return false;
        }else{
            itemsDAO.addItems(item);
            return true;
        }
    }

    @Override
    public void updateItems(Items item) {
        itemsDAO.addItems(item);
    }

    @Override
    public void deleteItems(long itemId) {
        itemsDAO.deleteItems(itemId);
    }


}
