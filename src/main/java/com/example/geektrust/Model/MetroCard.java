package com.example.geektrust.Model;

import com.example.geektrust.EnumAndConstants.Constants;

public class MetroCard {
    private final String metroCardID;

    private int currentBalance;

    private int passengerCount;

    public MetroCard(String metroCardID, int currentBalance) {
        this.metroCardID = metroCardID;
        this.currentBalance = currentBalance;
    }

    public String getMetroCardID() {
        return metroCardID;
    }

    public int getPassengerCount() {
        return this.passengerCount;
    }

    public void changePassengerCount(int passengerCount) {
        this.passengerCount+=passengerCount;
    }

    public int calculateAmount(int requiredAmount) {
        int amount = Constants.NUMBER_ZERO;
        if (isSufficientBalance(requiredAmount)) {
            this.currentBalance -= requiredAmount;
            amount += requiredAmount;
        } else {
            amount += requiredAmount;
            amount += (int) ((requiredAmount - this.currentBalance) * Constants.percentage);
            this.currentBalance = Constants.NUMBER_ZERO;
        }
        return amount;
    }

    private boolean isSufficientBalance(int requiredAmount) {
        return this.currentBalance >= requiredAmount;
    }

}
