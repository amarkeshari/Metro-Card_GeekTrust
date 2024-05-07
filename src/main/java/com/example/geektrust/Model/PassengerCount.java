package com.example.geektrust.Model;

import com.example.geektrust.EnumAndConstants.Constants;
import com.example.geektrust.EnumAndConstants.PassengerType;

public class PassengerCount {
    private int adultCount;

    private int kidsCount;

    private int seniorCitizenCount;

    public int getAdultCount() {
        return adultCount;
    }

    public int getKidsCount() {
        return kidsCount;
    }

    public int getSeniorCitizenCount() {
        return seniorCitizenCount;
    }

    public void increasePassengerCount(PassengerType passengerType) {
        switch (passengerType) {
            case KID:
                kidsCount += Constants.NUMBER_ONE;
                break;
            case ADULT:
                adultCount += Constants.NUMBER_ONE;
                break;
            case SENIOR_CITIZEN:
                seniorCitizenCount += Constants.NUMBER_ONE;
                break;
            default:
                break;
        }
    }
}
