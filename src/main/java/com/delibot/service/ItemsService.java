package com.delibot.service;

import com.delibot.domain.Items;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ItemsService {
    public List<Items> getItemsFromStore(Integer storeId);

    public Optional<Items> getItem(Integer id);
}
