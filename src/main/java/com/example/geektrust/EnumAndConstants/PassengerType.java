package com.example.geektrust.EnumAndConstants;

public enum PassengerType {
    ADULT(200),
    KID(50),
    SENIOR_CITIZEN(100);

    private final int fairValue;

    PassengerType(int fairValue) {
        this.fairValue=fairValue;
    }

    public int getFairValue() {
        return this.fairValue;
    }
}
