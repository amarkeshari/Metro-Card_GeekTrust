package com.example.geektrust.Model;

public class Journey {
    private String metroCardId;
    private String passenger;
    private Destination destination;

    public Journey(String metroCardId, String passenger, String destination) {
        this.metroCardId = metroCardId;
            this.passenger=passenger;
        if(destination.equals("AIRPORT")) {
            this.destination=Destination.AIRPORT;
        }
        else if(destination.equals("CENTRAL")) {
            this.destination=Destination.CENTRAL;
        }
    }

    public String getPassenger() {
        return passenger;
    }

    public String getMetroCardId() {
        return metroCardId;
    }

    public Destination getDestination() {
        return destination;
    }
}
