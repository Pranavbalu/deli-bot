package com.delibot.service;


import com.delibot.domain.Store;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StoreService {
    public void saveStore( Store store) ;

    public List<Store> findAll();

    public Optional<Store> findStore(Integer id);
}
