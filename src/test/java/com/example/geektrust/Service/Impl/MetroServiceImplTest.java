package com.example.geektrust.Service.Impl;

import com.example.geektrust.EnumAndConstants.Constants;
import com.example.geektrust.Model.Journey;
import com.example.geektrust.Model.MetroCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MetroServiceImplTest {

    private final MetroServiceImpl metroServiceImpl= new MetroServiceImpl();

    @Test
    public void testCreateMetroCard() {
        List <String> ansList= Arrays.asList("BALANCE","MC1", "600");
        MetroCard metroCard=metroServiceImpl.createMetroCard(ansList);
        Assertions.assertEquals(metroCard.getMetroCardID(),ansList.get(Constants.NUMBER_ONE));
    }

    @Test
    public void testCreateJourney() {
        List <String> ansList= Arrays.asList("CHECK_IN", "MC1", "ADULT", "CENTRAL");
        Journey journey =metroServiceImpl.createJourney(ansList);
        Assertions.assertEquals(journey.getMetroCardId(),ansList.get(Constants.NUMBER_ONE));
    }

    @Test
    public void testFindCollectionAndDiscountThrowsException() throws IOException {
        Assertions.assertThrows(IOException.class, () -> {
            metroServiceImpl.findCollectionAndDiscount("Test");
        });
    }

    @Test
    public void testfindCollectionAndDiscount() throws IOException {
        Assertions.assertThrows(IOException.class, () -> {
            metroServiceImpl.findCollectionAndDiscount("src/test/resources/input1.txt");
        });
    }


}
