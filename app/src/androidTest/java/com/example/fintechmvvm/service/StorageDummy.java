package com.example.fintechmvvm.service;

import com.example.fintechmvvm.db.Storage;

import java.util.List;

public class StorageDummy implements Storage {
    @Override
    public void save(String message) {

    }

    @Override
    public List<String> getMessages() {
        return null;
    }
}
