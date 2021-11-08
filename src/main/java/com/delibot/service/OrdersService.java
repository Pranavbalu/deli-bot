package com.delibot.service;

import com.delibot.domain.Orders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrdersService {
    public Orders saveOrder( Orders order) ;

    public List<Orders> getOrdersByDeliveryExecutiveID ( Integer id );

    public Optional<Orders> getOrder(Integer orderId);
}
