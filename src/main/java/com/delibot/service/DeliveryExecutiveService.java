package com.delibot.service;

import com.delibot.domain.DeliveryExecutive;
import org.springframework.stereotype.Service;

@Service
public interface DeliveryExecutiveService {


    public DeliveryExecutive findAvailableDeliveryExecutives(String location);

    void saveDeliveryExecutive(DeliveryExecutive deliveryExecutive);

    DeliveryExecutive findDeliveryExecutiveByUserId(Integer id);
}
