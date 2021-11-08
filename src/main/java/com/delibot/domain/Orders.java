package com.delibot.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Orders {

    public enum OrderStatus {
        ASSIGNED, DELIVERED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private Integer deliveryExecutiveId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    @ManyToMany
    @JoinTable(
            name = "orders_item_list",
            joinColumns = @JoinColumn(name = "orders_order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_list_id"))
    private List<Items> itemList;

    private Boolean isDelivered;

    private Integer feedbackId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }


    public Integer getDeliveryExecutiveId() {
        return deliveryExecutiveId;
    }

    public void setDeliveryExecutiveId(Integer deliveryExecutiveId) {
        this.deliveryExecutiveId = deliveryExecutiveId;
    }

    public List<Items> getItemList() {
        return itemList;
    }

    public void setItemList(List<Items> itemList) {
        this.itemList = itemList;
    }

    public Boolean getDelivered() {
        return isDelivered;
    }

    public void setDelivered(Boolean delivered) {
        isDelivered = delivered;
    }

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
