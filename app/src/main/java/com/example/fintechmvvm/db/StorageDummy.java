package com.example.fintechmvvm.db;

import java.util.ArrayList;
import java.util.List;

public class StorageDummy implements Storage{
    @Override
    public void save(String message) {

    }

    @Override
    public List<String> getMessages() {
        return new ArrayList<>();
    }
}
