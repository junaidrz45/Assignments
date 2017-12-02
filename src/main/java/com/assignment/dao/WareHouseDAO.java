package com.assignment.dao;

import com.assignment.entity.Brands;
import com.assignment.entity.WareHouse;
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
public class WareHouseDAO implements IWareHouseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<WareHouse> getAllWareHouse() {
        String hql = "FROM WareHouse as wareHouse ORDER BY wareHouse.warehouseid";
        return (List<WareHouse>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public WareHouse getWareHouseById(long wareHouseId) {
        return entityManager.find(WareHouse.class,wareHouseId);
    }

    @Override
    public void addWareHouse(WareHouse wareHouse) {
        entityManager.persist(wareHouse);
    }

    @Override
    public void updateWareHouse(WareHouse wareHouse) {
        WareHouse wrehouse = getWareHouseById(wareHouse.getWarehouseid());
        wrehouse.setName(wareHouse.getName());
        wrehouse.setBrands(wareHouse.getBrands());
        wrehouse.setCountry(wareHouse.getCountry());
        entityManager.flush();
    }

    @Override
    public void deleteWareHouse(long wareHouseId) {
        entityManager.remove(getWareHouseById(wareHouseId));
    }

    @Override
    public boolean wareHousesExists(String name) {
        String hql = "FROM WareHouse as wareHouse WHERE wareHouse.name = ? ";
        int count = entityManager.createQuery(hql).setParameter(1, name).getResultList().size();
        return count > 0 ? true : false;
    }
}
