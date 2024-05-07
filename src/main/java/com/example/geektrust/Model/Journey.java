package com.example.geektrust.Model;

import com.example.geektrust.EnumAndConstants.Destination;
import com.example.geektrust.EnumAndConstants.PassengerType;

public class Journey {
    private final String metroCardId;
    private final PassengerType passengerType;
    private final Destination destination;

    public Journey(String metroCardId, String passengerType, String destinationType) {
        this.metroCardId = metroCardId;
        this.passengerType = this.getPassengerType(passengerType);
        this.destination=this.getDestinationType(destinationType);
    }

    private Destination getDestinationType(String destinationType) {
        Destination destination = null;
        if (destinationType.equals("AIRPORT")) {
            destination = Destination.AIRPORT;
        } else if (destinationType.equals("CENTRAL")) {
            destination = Destination.CENTRAL;
        }
        return destination;
    }

    private PassengerType getPassengerType(String passenger) {
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
