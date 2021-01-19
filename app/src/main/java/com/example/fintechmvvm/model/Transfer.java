package com.example.fintechmvvm.model;

import androidx.databinding.BaseObservable;

public class Transfer extends BaseObservable{

    private String amount;
    private String from;
    private String to;

    public String getAmount() {
        return amount;
    }

    public int getAmountInt(){
        try{
            return Integer.parseInt(this.amount);
        }
        catch (Exception ex){
            return 0;
        }
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "amount=" + amount +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
