package com.example.geektrust.Service.Impl;

import com.example.geektrust.EnumAndConstants.Constants;
import com.example.geektrust.EnumAndConstants.Destination;
import com.example.geektrust.EnumAndConstants.PassengerType;
import com.example.geektrust.Model.*;
import com.example.geektrust.Service.CollectionAndPassengerDetails;
import com.example.geektrust.Service.PrintSummary;

import java.util.*;

public class CollectionAndPassengerDetailsImpl implements CollectionAndPassengerDetails {

    private final PrintSummary printSummary;

    public CollectionAndPassengerDetailsImpl() {
        this.printSummary=new PrintSummaryImpl();
    }

    public List<String> calculateCollection(List<MetroCard> metroCardList, List<Journey> journeyList) throws IndexOutOfBoundsException{
        List<Integer> collectedAmount = Arrays.asList(Constants.NUMBER_ZERO, Constants.NUMBER_ZERO);
        List<Integer> collectedDiscountAmount = Arrays.asList(Constants.NUMBER_ZERO, Constants.NUMBER_ZERO);
        List<PassengerCount> passengerCountList = Arrays.asList(new PassengerCount(), new PassengerCount());
        for (Journey journey : journeyList) {
            int fairAmount = journey.getPassenger().getFairValue(),curFair, curDiscount;
            List<Integer> ansList;
            MetroCard curMetroCard = null;
            for (MetroCard metroCard : metroCardList) {
                if (journey.getMetroCardId().equals(metroCard.getMetroCardID())) {
                    curMetroCard = metroCard;
                }
            }
            if (journey.getDestination().equals(Destination.CENTRAL)) {
                ansList = calculateCollectionAndDiscount(journey.getPassenger(), fairAmount, curMetroCard, passengerCountList.get(Constants.NUMBER_ZERO));
                curFair = curMetroCard.calculateAmount(ansList.get(Constants.NUMBER_ZERO));
                curDiscount = ansList.get(Constants.NUMBER_ONE);
                collectedAmount.set(Constants.NUMBER_ZERO, collectedAmount.get(Constants.NUMBER_ZERO) + curFair);
                collectedDiscountAmount.set(Constants.NUMBER_ZERO, collectedDiscountAmount.get(Constants.NUMBER_ZERO) + curDiscount);
            } else if (journey.getDestination().equals(Destination.AIRPORT)) {
                ansList = calculateCollectionAndDiscount(journey.getPassenger(), fairAmount, curMetroCard, passengerCountList.get(Constants.NUMBER_ONE));
                curFair = curMetroCard.calculateAmount(ansList.get(Constants.NUMBER_ZERO));
                curDiscount = ansList.get(Constants.NUMBER_ONE);
                collectedAmount.set(Constants.NUMBER_ONE, collectedAmount.get(Constants.NUMBER_ONE) + curFair);
                collectedDiscountAmount.set(Constants.NUMBER_ONE, collectedDiscountAmount.get(Constants.NUMBER_ONE) + curDiscount);
            }
        }
        return printSummary.createResultList(collectedAmount, collectedDiscountAmount, passengerCountList);
    }


    private List<Integer> calculateCollectionAndDiscount(PassengerType passengerType, int fairAmount, MetroCard curMetroCard, PassengerCount passengerCount) {
        int ticketAmount, discountAmount = Constants.NUMBER_ZERO;
        if (curMetroCard.getPassengerCount() <= Constants.NUMBER_ZERO) {
            ticketAmount = fairAmount;
            curMetroCard.changePassengerCount(Constants.NUMBER_ONE);
        } else {
            ticketAmount = fairAmount / Constants.NUMBER_TWO;
            discountAmount = fairAmount / Constants.NUMBER_TWO;
            curMetroCard.changePassengerCount(-Constants.NUMBER_ONE);
        }
        passengerCount.increasePassengerCount(passengerType);
        return Arrays.asList(ticketAmount, discountAmount);
    }

}
