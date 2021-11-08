package com.delibot.repository;

import com.delibot.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.userName = ?1")
    public User findByUserName(String userName);

    @Query("SELECT u FROM User u WHERE u.userType = 'DELIVERY_EXECUTIVE' AND location= ?1")
    public User findAvailableDeliveryExecutives(String location);

}
