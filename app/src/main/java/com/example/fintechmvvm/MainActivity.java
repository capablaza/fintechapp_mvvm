package com.example.fintechmvvm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.fintechmvvm.api.TransferClientStub;
import com.example.fintechmvvm.databinding.ActivityMainBinding;
import com.example.fintechmvvm.db.StorageDummy;
import com.example.fintechmvvm.service.ITransfer;
import com.example.fintechmvvm.service.TransferService;
import com.example.fintechmvvm.viewmodel.TransferViewModel;

public class MainActivity extends AppCompatActivity {

    ITransfer service = new TransferService(new TransferClientStub(), new StorageDummy());

    TransferViewModel viewModel = new TransferViewModel(service);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel.addContext(getApplicationContext());

        binding.setViewModel(viewModel);
        viewModel.onCreate();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.onDestroy();
    }
}