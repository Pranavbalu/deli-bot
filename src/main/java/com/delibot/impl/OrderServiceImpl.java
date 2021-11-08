package com.delibot.impl;


import com.delibot.domain.Orders;
import com.delibot.repository.OrdersRepository;
import com.delibot.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Orders saveOrder(Orders order) {
        return ordersRepository.save(order);
    }

    @Override
    public List<Orders> getOrdersByDeliveryExecutiveID(Integer id) {
        return ordersRepository.getOrdersByDeliveryExecutiveID(id);
    }

    public Optional<Orders> getOrder(Integer orderId) {
        return ordersRepository.findById(orderId);
    }
}
