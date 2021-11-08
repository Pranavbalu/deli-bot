package com.delibot.controller;

import com.delibot.domain.CustomUserDetails;
import com.delibot.domain.DeliveryExecutive;
import com.delibot.domain.Orders;
import com.delibot.service.DeliveryExecutiveService;
import com.delibot.service.OrdersService;
import com.delibot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {
    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UserService userService;

    @Autowired
    private DeliveryExecutiveService deliveryExecutiveService;

    @PostMapping("/changeDeliveryStatus")
    public @ResponseBody
    String changeDeliveryStatus(@RequestParam String orderIds) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        CustomUserDetails customUserDetails = (CustomUserDetails) userService.loadUserByUsername(userName);
        List<String> orderIdList = orderIds.contains(",") ? Arrays.asList(StringUtils.split(orderIds,",")) : Arrays.asList(orderIds);

        for(String orderId : orderIdList) {
            Optional optionalOrder = ordersService.getOrder(Integer.parseInt(orderId));
            if ( optionalOrder.isPresent() ) {
                Orders order = (Orders) optionalOrder.get();
                order.setStatus(Orders.OrderStatus.DELIVERED);
                ordersService.saveOrder(order);
            }
        }

        DeliveryExecutive deliveryExecutive = deliveryExecutiveService.findDeliveryExecutiveByUserId(customUserDetails.getUser().getId());
        if ( deliveryExecutive != null ) {
            deliveryExecutive.setFree(true);
            deliveryExecutiveService.saveDeliveryExecutive(deliveryExecutive);
        }
        return "Delivery status changed.";
    }
}
