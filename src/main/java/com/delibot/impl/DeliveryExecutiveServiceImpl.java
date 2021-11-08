package com.delibot.impl;

import com.delibot.domain.DeliveryExecutive;
import com.delibot.repository.DeliveryExecutiveRepository;
import com.delibot.service.DeliveryExecutiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryExecutiveServiceImpl implements DeliveryExecutiveService {
    @Autowired
    private DeliveryExecutiveRepository deliveryExecutiveRepo;

    @Override
    public DeliveryExecutive findAvailableDeliveryExecutives(String location) {
        return deliveryExecutiveRepo.findAvailableDeliveryExecutives(location);
    }

    @Override
    public void saveDeliveryExecutive(DeliveryExecutive deliveryExecutive) {
        deliveryExecutiveRepo.save(deliveryExecutive);
    }

    @Override
    public DeliveryExecutive findDeliveryExecutiveByUserId(Integer id) {
        return deliveryExecutiveRepo.findDeliveryExecutiveByUserId(id);
    }

}
