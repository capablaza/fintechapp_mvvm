package com.example.fintechmvvm.api;

public class TransferRequest {
    private Integer amount;
    private String from;
    private String to;

    public TransferRequest(Integer amount, String from, String to) {
        this.amount = amount;
        this.from = from;
        this.to = to;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
