package com.example.geektrust.Model;

public class MetroCard {
    private String metroCardID;

    private int currentBalance;

    private int adultCount;

    private int kidsCount;

    private int seniorCitizenCount;

    public MetroCard(String metroCardID, int currentBalance) {
        this.metroCardID = metroCardID;
        this.currentBalance = currentBalance;
        this.adultCount = 0;
        this.kidsCount = 0;
        this.seniorCitizenCount = 0;
    }

    public String getMetroCardID() {
        return metroCardID;
    }

    public int getPassengerCount(String passengerType) {
        int passengerCount;
        switch (passengerType) {
            case "KID":
                passengerCount = kidsCount;
                break;
            case "ADULT":
                passengerCount = adultCount;
                break;
            case "SENIOR_CITIZEN":
                passengerCount = seniorCitizenCount;
                break;
            default:
                passengerCount = 0;
                break;
        }
        return passengerCount;
    }

    public void changePassengerCount(String passengerType, int passengerNumber) {
        switch (passengerType) {
            case "KID":
                kidsCount += passengerNumber;
                kidsCount = (Math.max(kidsCount, 0));
                break;
            case "ADULT":
                adultCount += passengerNumber;
                adultCount = (Math.max(adultCount, 0));
                break;
            case "SENIOR_CITIZEN":
                seniorCitizenCount += passengerNumber;
                adultCount = (Math.max(adultCount, 0));
                break;
            default:
                break;
        }
    }

    public double calculateAmount(int requiredAmount) {
        double amount = 0;
        if (isSufficientBalance(requiredAmount)) {
            this.currentBalance -= requiredAmount;
            amount += requiredAmount;
        } else {
            amount += requiredAmount;
            amount += ((requiredAmount - this.currentBalance) * 0.02f);
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
