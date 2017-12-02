package com.assignment.dao;

import com.assignment.entity.Items;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by junaid on 29/11/2017.
 */

@Transactional
@Repository
public class ItemsDAO implements IItemsDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Items> getAllItems() {
        String hql = "FROM Items as item ORDER BY item.itemid";
        return (List<Items>) entityManager.createQuery(hql).getResultList();

    }

    @Override
    public List<Items> getAllItemsByCountry(String countryName) {
        String hql = "FROM Items as item WHERE item.wareHouse.country.name= ? ";
        return (List<Items>) entityManager.createQuery(hql).setParameter(1, countryName).getResultList();
    }

    @Override
    public Items getItemsById(long ItemsId) {
        return entityManager.find(Items.class,ItemsId);
    }

    @Override
    public void addItems(Items items) {
        entityManager.persist(items);
    }

    @Override
    public void updateItems(Items items) {
        Items item = getItemsById(items.getItemid());
        item.setAvailableQuantity(items.getAvailableQuantity());
        item.setInTransitQuantity(items.getInTransitQuantity());
        item.setItemTypes(items.getItemTypes());
        item.setMOQ(items.getMOQ());
        item.setName(items.getName());
        item.setSize(items.getSize());
        item.setRecorderPoint(items.getRecorderPoint());
        item.setWareHouse(items.getWareHouse());
        entityManager.flush();
    }

    @Override
    public void deleteItems(long itemsId) {
        entityManager.remove(getItemsById(itemsId));
    }

    @Override
    public boolean itemExists(String name) {
        String hql = "FROM Items as item WHERE item.name = ? ";
        int count = entityManager.createQuery(hql).setParameter(1, name).getResultList().size();
        return count > 0 ? true : false;
    }


}
