package com.delibot.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String itemName;

    private String itemPrice;

    private Integer storeId;

    @ManyToMany(mappedBy = "itemList")
    private List<Orders> ordersList;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
