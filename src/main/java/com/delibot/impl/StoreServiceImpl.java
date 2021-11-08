package com.delibot.impl;

import com.delibot.domain.Store;
import com.delibot.repository.StoreRepository;
import com.delibot.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public void saveStore(Store store) {
        storeRepository.save(store);
    }

    @Override
    public List<Store> findAll() {
        return (List<Store>) storeRepository.findAll();
    }

    @Override
    public Optional<Store> findStore(Integer id) {
        return storeRepository.findById(id);
    }
}
