package com.delibot.impl;

import com.delibot.domain.Items;
import com.delibot.repository.ItemsRepository;
import com.delibot.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemsService {
    @Autowired
    private ItemsRepository itemsRepository;

    @Override
    public List<Items> getItemsFromStore(Integer storeId) {
        return itemsRepository.findItemsFromStore(storeId);
    }

    @Override
    public Optional<Items> getItem(Integer id) {
        return itemsRepository.findById(id);
    }
}
