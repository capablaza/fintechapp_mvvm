package com.example.fintechmvvm.service;

public class TransferResponse {
    private Integer code;
    private String message;

    public TransferResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
