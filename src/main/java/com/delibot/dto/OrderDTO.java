package com.delibot.dto;

import com.delibot.domain.Orders;
import com.delibot.domain.Store;
import com.delibot.domain.User;

import javax.persistence.Entity;

@Entity
public class OrderDTO {

    private Integer id;

    private User user;

    private String items;

    private Store store;

    private Orders.OrderStatus orderStatus;

    private boolean delivered;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Orders.OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Orders.OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}
