package com.example.geektrust.Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JourneyTest {

    Journey journey=new Journey("1","KID","AIRPORT");

    @Test
    public void testJourney() {
        Assertions.assertEquals(journey.getClass(),Journey.class);
    }

}
