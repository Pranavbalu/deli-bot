package com.delibot.repository;

import com.delibot.domain.Items;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemsRepository extends CrudRepository<Items, Integer> {
    @Query("SELECT i FROM Items i WHERE i.storeId = ?1")
    public List<Items> findItemsFromStore(Integer storeId);
}
