package com.example.geektrust.Model;

import com.example.geektrust.EnumAndConstants.PassengerType;
import org.junit.jupiter.api.Test;

public class PassengerCountTest {

    PassengerCount passengerCount = new PassengerCount();

    @Test
    public void testIncreasePassengerCount() {
        PassengerType passengerType=PassengerType.KID;
        passengerCount.increasePassengerCount(passengerType);
    }
}
