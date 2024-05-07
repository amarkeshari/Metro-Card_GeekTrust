package com.example.geektrust.Model;

import com.example.geektrust.Model.PassengerType;

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
                kidsCount += 1;
                break;
            case ADULT:
                adultCount += 1;
                break;
            case SENIOR_CITIZEN:
                seniorCitizenCount += 1;
                break;
            default:
                break;
        }
    }
}
