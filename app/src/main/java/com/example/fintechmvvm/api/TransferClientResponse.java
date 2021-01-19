package com.example.fintechmvvm.api;

public class TransferClientResponse {

    private String message;
    private Integer code;

    public TransferClientResponse(Integer code, String message  ) {
        this.message = message;
        this.code = code;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
