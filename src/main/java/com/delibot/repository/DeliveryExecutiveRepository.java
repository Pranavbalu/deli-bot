package com.delibot.repository;

import com.delibot.domain.DeliveryExecutive;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface DeliveryExecutiveRepository extends CrudRepository<DeliveryExecutive, Integer> {


    @Query("SELECT d FROM DeliveryExecutive d JOIN User u on u.id= d.userId WHERE d.isFree = 1 AND u.location=?1")
    public DeliveryExecutive findAvailableDeliveryExecutives(String location);

    @Query("SELECT d FROM DeliveryExecutive d  WHERE d.userId=?1")
    public DeliveryExecutive findDeliveryExecutiveByUserId(Integer id);
}
