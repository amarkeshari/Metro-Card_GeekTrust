package com.example.geektrust.Service.Impl;

import com.example.geektrust.Model.Journey;
import com.example.geektrust.Model.MetroCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionAndPassengerDetailsImplTest {

    private final CollectionAndPassengerDetailsImpl collectionAndPassengerDetails=
            new CollectionAndPassengerDetailsImpl();

    @Test
    public void testCalculateCollection() {
        List<MetroCard> metroCardList=new ArrayList<>();
        List<Journey > journeyList=new ArrayList<>();
        List <String> expectedList= Arrays.asList("TOTAL_COLLECTION CENTRAL 0 0", "PASSENGER_TYPE_SUMMARY", "TOTAL_COLLECTION AIRPORT 0 0", "PASSENGER_TYPE_SUMMARY");
        Assertions.assertEquals(collectionAndPassengerDetails.calculateCollection(metroCardList,journeyList),expectedList);
    }
}
