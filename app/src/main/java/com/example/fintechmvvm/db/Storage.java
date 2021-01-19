package com.example.fintechmvvm.db;

import java.util.List;

public interface Storage {
    void save(String message);
    List<String> getMessages();
}
