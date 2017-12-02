package com.assignment.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by junaid on 27/11/2017.
 */
@Entity
@Table(name="items")
public class Items implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="item_id")
    private long itemid;

    @Column(name = "names")
    private String name;

    @OneToOne
    @JoinColumn(name = "itemtype_id")
    private ItemTypes itemTypes;

    @Column(name="size")
    private String size;

    @Column(name = "AvailableQuantity")
    private long availableQuantity;

    @Column(name = "InTransitQuantity")
    private long inTransitQuantity;

    @Column(name = "MOQ")
    private long MOQ;

    @Column(name = "QPB")
    private long QPB;

    @Column(name = "RecorderPoint")
    private long RecorderPoint;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private WareHouse wareHouse;


    public long getItemid() {
        return itemid;
    }

    public void setItemid(long itemid) {
        this.itemid = itemid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public long getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(long availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public long getInTransitQuantity() {
        return inTransitQuantity;
    }

    public void setInTransitQuantity(long inTransitQuantity) {
        this.inTransitQuantity = inTransitQuantity;
    }

    public long getMOQ() {
        return MOQ;
    }

    public void setMOQ(long MOQ) {
        this.MOQ = MOQ;
    }

    public long getQPB() {
        return QPB;
    }

    public void setQPB(long QPB) {
        this.QPB = QPB;
    }

    public long getRecorderPoint() {
        return RecorderPoint;
    }

    public void setRecorderPoint(long recorderPoint) {
        RecorderPoint = recorderPoint;
    }

    public ItemTypes getItemTypes() {
        return itemTypes;
    }

    public void setItemTypes(ItemTypes itemTypes) {
        this.itemTypes = itemTypes;
    }

    public WareHouse getWareHouse() {
        return wareHouse;
    }

    public void setWareHouse(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }
}
