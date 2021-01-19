package com.example.fintechmvvm.viewmodel;

import android.content.Context;
import android.widget.Toast;

import com.example.fintechmvvm.model.Transfer;
import com.example.fintechmvvm.service.ITransfer;
import com.example.fintechmvvm.service.TransferResponse;

public class TransferViewModel implements ViewModel {

    private Transfer model;
    ITransfer service;

    Context context;

    public Transfer getModel() {
        return model;
    }

    public TransferViewModel(ITransfer service){
        this.service = service;
        model = new Transfer();
    }

    public void addContext(Context ctx){
        this.context = ctx;
    }

    public void onClickTransferAction(){

        TransferResponse response = service.transfer(model.getFrom(), model.getTo(), model.getAmountInt());

        toastMessage(response.message());

    }

    private void toastMessage(String message){
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }
}
