package com.example.fintechmvvm.service;

public interface ITransfer {

    TransferResponse transfer(String from, String to, int amount);
}
