package com.delibot.repository;

import com.delibot.domain.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface OrdersRepository extends CrudRepository<Orders, Integer> {

    @Query("SELECT o FROM Orders o WHERE o.deliveryExecutiveId = ?1")
    List<Orders> getOrdersByDeliveryExecutiveID(Integer id);
}
