package com.assignment.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by junaid on 27/11/2017.
 */

@Entity
@Table(name="itemsTypes")
public class ItemTypes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="itemtype_id")
    private long itemtypeid;

    @Column(name = "name")
    private String name;

    @Column(name = "sizes")
    private String sizes;

    public long getItemtypeid() {
        return itemtypeid;
    }

    public void setItemtypeid(long itemtypeid) {
        this.itemtypeid = itemtypeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }
}
