package com.example.fintechmvvm.service;

import com.example.fintechmvvm.api.TransferClient;
import com.example.fintechmvvm.api.TransferRequest;
import com.example.fintechmvvm.db.Storage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TransferServiceSolutionTest {

    @Before
    public void setUp() {
    }

    @Test
    public void testGivenTransRequestWhenAmountIsLessThanZeroThenResponseIs520() {
        TransferClient client = new TransferClientStub(520, "");
        Storage storage = new StorageDummy();

        TransferService service = new TransferService(client, storage);

        int amount = -100;

        TransferRequest request = new TransferRequest(amount, "", "");

        TransferResponse response = service.transfer(request.getFrom(),request.getTo(),request.getAmount());

        Assert.assertEquals(response.code(), 520);
    }

    @Test
    public void testGivenTransRequestWhenAmountIsEqualToZeroThenResponseIs520() {
        TransferClient client = new TransferClientStub(520, "");
        Storage storage = new StorageDummy();

        TransferService service = new TransferService(client, storage);

        int amount = 0;

        TransferRequest request = new TransferRequest(amount, "", "");

        TransferResponse response = service.transfer(request.getFrom(),request.getTo(),request.getAmount());

        Assert.assertEquals(response.code(), 520);
    }

    @Test
    public void testGivenTransRequestWhenAmountIsMajorThanMaximumThenResponseIs521() {
        TransferClient client = new TransferClientStub(521, "");
        Storage storage = new StorageDummy();

        TransferService service = new TransferService(client, storage);

        int amount = 500000;

        TransferRequest request = new TransferRequest(amount, "", "");

        TransferResponse response = service.transfer(request.getFrom(),request.getTo(),request.getAmount());

        Assert.assertEquals(response.code(), 521);
    }

    @Test
    public void testGivenTransRequestWhenOriginsAreEqualsThenResponseIs522() {
        TransferClient client = new TransferClientStub(522, "");
        Storage storage = new StorageDummy();

        TransferService service = new TransferService(client, storage);

        int amount = 100;
        String from = "8736 8474 9034";
        String to = "8736 8474 9034";

        TransferRequest request = new TransferRequest(amount, from, to);

        TransferResponse response = service.transfer(request.getFrom(),request.getTo(),request.getAmount());

        Assert.assertEquals(response.code(), 522);
    }

    @Test
    public void testGivenTransRequestWhenConditionsAreBadThenSaveErrorInStorage() {
        TransferClient client = new TransferClientStub(521, "");
        Storage storage = new StorageFake();

        TransferService service = new TransferService(client, storage);

        int amount = 500000;

        TransferRequest request = new TransferRequest(amount, "", "");

        TransferResponse response = service.transfer(request.getFrom(),request.getTo(),request.getAmount());

        Assert.assertEquals(response.code(), 521);
        Assert.assertFalse(storage.getMessages().isEmpty());
    }

    @After
    public void tearDown() {
    }
}
