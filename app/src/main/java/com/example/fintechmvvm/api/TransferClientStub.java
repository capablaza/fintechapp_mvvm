package com.example.fintechmvvm.api;

public class TransferClientStub implements TransferClient{
    @Override
    public TransferClientResponse transfer(TransferRequest request) {

        TransferClientResponse response = new TransferClientResponse(200, "Transfer accepted.");

        int amount = request.getAmount();
        String from = request.getFrom();
        String to = request.getTo();

        if (amount <= 0 ) {
            return new TransferClientResponse(520, "stub - The amount must be major than zero.");
        }
        if (amount > 200000) {
            return new TransferClientResponse(521, "stub - The amount can't be major than 200.000.");
        }
        if (from.equals(to)) {
            return new TransferClientResponse(522, "stub - The accounts can't be equals.");
        }

        return response;
    }
}
