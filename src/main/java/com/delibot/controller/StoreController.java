package com.delibot.controller;

import com.delibot.domain.*;
import com.delibot.dto.OrderDTO;
import com.delibot.service.OrdersService;
import com.delibot.service.StoreService;
import com.delibot.service.UserService;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class StoreController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrdersService ordersService;



    @GetMapping("/home")
    public String listRestaurants(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        CustomUserDetails customUserDetails = (CustomUserDetails) userService.loadUserByUsername(userName);

        if(customUserDetails.getUser().getUserType().equals(User.UserType.CUSTOMER)) {
            List<Store> listStore = (List<Store>) storeService.findAll();
            model.addAttribute("listStores", listStore);
            return "home";
        } else {
            List<Orders> listOrders = (List<Orders>) ordersService.getOrdersByDeliveryExecutiveID(customUserDetails.getUser().getId());
            List<OrderDTO> orderDTOList = new ArrayList<>();
            for ( Orders order : listOrders ){
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setId(order.getOrderId());
                orderDTO.setStore(order.getStore());
                orderDTO.setUser(order.getUser());
                orderDTO.setItems(StringUtils.join( order.getItemList().stream().map(Items::getItemName).collect(Collectors.toList()) ,
                        ','));
                orderDTO.setDelivered(order.getStatus().equals(Orders.OrderStatus.DELIVERED) ? true : false);
                orderDTO.setOrderStatus(order.getStatus());
                orderDTOList.add(orderDTO);
            }
            model.addAttribute("listOrders", orderDTOList);
            return "delivery_home";
        }

    }

    @PostMapping(path="/addStore") // Map ONLY POST Requests
    public @ResponseBody
    String addNewStore  (@RequestParam String name
            , @RequestParam String location
            , @RequestParam String imagePath) {

        Store store = new Store();
        store.setStoreName(name);
        store.setLocation(location);
        store.setImageLocation(imagePath);
        storeService.saveStore(store);
        return "Saved";
    }


}
