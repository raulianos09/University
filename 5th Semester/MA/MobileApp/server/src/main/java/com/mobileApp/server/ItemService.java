package com.mobileApp.server;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements IItemService{
    @Override
    public List<Items> findAll() {
        return null;
    }
}
