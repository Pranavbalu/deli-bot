package com.delibot.controller;

import com.delibot.domain.*;
import com.delibot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UserService userService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private DeliveryExecutiveService deliveryExecutiveService;

    @GetMapping(path="/listItems")
    public String listItems  (Model model, @RequestParam Integer storeId) {

        List<Items> itemsList = (List<Items>) itemsService.getItemsFromStore(storeId);
        model.addAttribute("itemsList", itemsList);
        return "listItems";
    }

    @PostMapping("/buyItems")
    public @ResponseBody
    String buyItems(@RequestParam String itemIds) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        CustomUserDetails customUserDetails = (CustomUserDetails) userService.loadUserByUsername(userName);
        List<String> itemIDs = itemIds.contains(",") ? Arrays.asList(StringUtils.split(itemIds,",")) : Arrays.asList(itemIds);
        List<Items> itemsList = new ArrayList<>();
        Integer storeId;
        for(String id : itemIDs ){
            System.out.println(Integer.parseInt(id));
            Optional item = itemsService.getItem(Integer.parseInt(id));
            if(item.isPresent()){
                itemsList.add((Items) item.get());
            }
        }
        if ( !CollectionUtils.isEmpty(itemsList)) {
            Orders newOrder = new Orders();
            storeId = itemsList.get(0).getStoreId();
            Optional item = storeService.findStore(storeId);
            if(item.isPresent()){
               newOrder.setStore((Store) item.get());
            }
            newOrder.setItemList(itemsList);
            newOrder.setDelivered(false);
            newOrder.setStatus(Orders.OrderStatus.ASSIGNED);
            newOrder.setUser(customUserDetails.getUser());
            DeliveryExecutive deliveryExecutive = deliveryExecutiveService.findAvailableDeliveryExecutives(customUserDetails.getUser().getLocation());
            if ( deliveryExecutive != null ){
                newOrder.setDeliveryExecutiveId(deliveryExecutive.getUserId());
                newOrder = ordersService.saveOrder(newOrder);
                deliveryExecutive.setCurrentOrderId(newOrder.getOrderId());
                deliveryExecutive.setFree(false);
                deliveryExecutiveService.saveDeliveryExecutive(deliveryExecutive);
                return "Order placed successfully.";
            } else {
                return "No delivery executives available for your area. Please try again after some time.";
            }
        }else {
            return "No items selected. Please select valid items.";
        }


    }
}
