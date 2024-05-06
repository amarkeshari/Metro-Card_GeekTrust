package com.example.geektrust.Service;

import com.example.geektrust.Model.Destination;
import com.example.geektrust.Model.Journey;
import com.example.geektrust.Model.MetroCard;
import com.example.geektrust.Model.PassengerCount;

import java.util.List;

public interface CollectionAndPassengerDetails {

    public List<String> calculateCollection(List <MetroCard> metroCardList, List <Journey> journeyList);
}
