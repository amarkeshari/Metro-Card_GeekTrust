package com.example.geektrust.Model;

public class Journey {
    private final String metroCardId;
    private final PassengerType passengerType;
    private Destination destination;

    public Journey(String metroCardId, String passengerType, String destination) {
        this.metroCardId = metroCardId;
        this.passengerType = this.getPassengerType(passengerType);
        if (destination.equals("AIRPORT")) {
            this.destination = Destination.AIRPORT;
        } else if (destination.equals("CENTRAL")) {
            this.destination = Destination.CENTRAL;
        }
    }

    public PassengerType getPassengerType(String passenger) {
        PassengerType passengerType = null;
        switch (passenger) {
            case "KID":
                passengerType=PassengerType.KID;
                break;
            case "ADULT":
                passengerType=PassengerType.ADULT;
                break;
            case "SENIOR_CITIZEN":
                passengerType=PassengerType.SENIOR_CITIZEN;
                break;
            default:
                break;
        }
        return passengerType;
    }

    public PassengerType getPassenger() {
        return passengerType;
    }

    public String getMetroCardId() {
        return metroCardId;
    }

    public Destination getDestination() {
        return destination;
    }
}
