package com.example.geektrust.Model;

public class MetroCard {
    private String metroCardID;

    private int currentBalance;

    private int passengerCount;

    public MetroCard(String metroCardID, int currentBalance) {
        this.metroCardID = metroCardID;
        this.currentBalance = currentBalance;
        this.passengerCount = 0;
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
        int amount = 0;
        if (isSufficientBalance(requiredAmount)) {
            this.currentBalance -= requiredAmount;
            amount += requiredAmount;
        } else {
            amount += requiredAmount;
            amount += (int) ((requiredAmount - this.currentBalance) * 0.02);
            this.currentBalance = 0;
        }
        return amount;
    }

    private boolean isSufficientBalance(int requiredAmount) {
        if (this.currentBalance < requiredAmount) {
            return false;
        }
        return true;
    }

}
