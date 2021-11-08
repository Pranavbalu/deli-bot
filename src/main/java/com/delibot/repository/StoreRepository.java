package com.delibot.repository;

import com.delibot.domain.Store;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface StoreRepository extends CrudRepository<Store, Integer> {

}
