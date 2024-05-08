package com.example.geektrust.Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MetroCardTest {

    MetroCard metroCard;

    @BeforeEach
    public void setUp() {
        metroCard=new MetroCard("1",100);
    }

    @Test
    public void testChangePassengerCount() {
        metroCard.changePassengerCount(1);
    }

    @Test
    public void testCalculateAmountRecharge() {
        Assertions.assertEquals(metroCard.calculateAmount(200),202);
    }

    @Test
    public void testCalculateAmount() {
        Assertions.assertEquals(metroCard.calculateAmount(100),100);
    }

}
