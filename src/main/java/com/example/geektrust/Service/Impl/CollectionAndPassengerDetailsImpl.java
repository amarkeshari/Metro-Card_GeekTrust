package com.example.geektrust.Service.Impl;

import com.example.geektrust.Model.*;
import com.example.geektrust.Service.CollectionAndPassengerDetails;

import java.util.*;

public class CollectionAndPassengerDetailsImpl implements CollectionAndPassengerDetails {

    public List<String> calculateCollection(List<MetroCard> metroCardList, List<Journey> journeyList) {
        List<Integer> collectedAmount = Arrays.asList(Constants.NUMBER_ZERO, Constants.NUMBER_ZERO);
        List<Integer> collectedDiscountAmount = Arrays.asList(Constants.NUMBER_ZERO, Constants.NUMBER_ZERO);
        List<PassengerCount> passengerCountList = Arrays.asList(new PassengerCount(), new PassengerCount());
        for (Journey journey : journeyList) {
            PassengerType curPassenger = journey.getPassenger();
            Destination curDestination = journey.getDestination();
            int fairAmount = curPassenger.getFairValue();
            List<Integer> ansList;
            MetroCard curMetroCard = null;
            int curFair, curDiscount;
            for (MetroCard metroCard : metroCardList) {
                if (journey.getMetroCardId().equals(metroCard.getMetroCardID())) {
                    curMetroCard = metroCard;
                }
            }
            if (curDestination.equals(Destination.CENTRAL)) {
                ansList = init(curPassenger, fairAmount, curMetroCard, passengerCountList.get(Constants.NUMBER_ZERO));
                curFair = curMetroCard.calculateAmount(ansList.get(Constants.NUMBER_ZERO));
                curDiscount = ansList.get(Constants.NUMBER_ONE);
                collectedAmount.set(Constants.NUMBER_ZERO, collectedAmount.get(Constants.NUMBER_ZERO) + curFair);
                collectedDiscountAmount.set(Constants.NUMBER_ZERO, collectedDiscountAmount.get(Constants.NUMBER_ZERO) + curDiscount);
            } else if (curDestination.equals(Destination.AIRPORT)) {
                ansList = init(curPassenger, fairAmount, curMetroCard, passengerCountList.get(Constants.NUMBER_ONE));
                curFair = curMetroCard.calculateAmount(ansList.get(Constants.NUMBER_ZERO));
                curDiscount = ansList.get(Constants.NUMBER_ONE);
                collectedAmount.set(Constants.NUMBER_ONE, collectedAmount.get(Constants.NUMBER_ONE) + curFair);
                collectedDiscountAmount.set(Constants.NUMBER_ONE, collectedDiscountAmount.get(Constants.NUMBER_ONE) + curDiscount);
            }
        }
        return createResultList(collectedAmount, collectedDiscountAmount, passengerCountList);
    }


    public List<Integer> init(PassengerType passengerType, int fairAmount, MetroCard curMetroCard, PassengerCount passengerCount) {
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

    public List<String> createResultList(List<Integer> collectedAmount, List<Integer> collectedDiscountAmount,
                                         List<PassengerCount> passengerCountList) {
        List<String> ansList = new ArrayList<>();
        ansList.add("TOTAL_COLLECTION " + Destination.CENTRAL + " " + collectedAmount.get(Constants.NUMBER_ZERO) + " " + collectedDiscountAmount.get(Constants.NUMBER_ZERO));
        ansList.add("PASSENGER_TYPE_SUMMARY");
        ansList = getPassenegrCount(ansList, passengerCountList.get(Constants.NUMBER_ZERO));
        ansList.add("TOTAL_COLLECTION " + Destination.AIRPORT + " " + collectedAmount.get(Constants.NUMBER_ONE) + " " + collectedDiscountAmount.get(Constants.NUMBER_ONE));
        ansList.add("PASSENGER_TYPE_SUMMARY");
        ansList = getPassenegrCount(ansList, passengerCountList.get(Constants.NUMBER_ONE));
        return ansList;
    }

    public List<String> getPassenegrCount(List<String> ansList, PassengerCount passengerCount) {
        HashMap<String, Integer> passengerMap = new HashMap<>();
        if (passengerCount.getKidsCount() > Constants.NUMBER_ZERO) {
            passengerMap.put("KID", passengerCount.getKidsCount());
        }
        if (passengerCount.getAdultCount() > Constants.NUMBER_ZERO) {
            passengerMap.put("ADULT", passengerCount.getAdultCount());
        }
        if (passengerCount.getSeniorCitizenCount() > Constants.NUMBER_ZERO) {
            passengerMap.put("SENIOR_CITIZEN", passengerCount.getSeniorCitizenCount());
        }
        List<Map.Entry<String, Integer> > list = new LinkedList<>(passengerMap.entrySet());
        list.sort((o1, o2) -> {
            int val = Constants.NUMBER_ZERO;
            if ((o1.getValue()).compareTo(o2.getValue()) > Constants.NUMBER_ZERO) {
                val = -Constants.NUMBER_ONE;
            } else if ((o1.getValue()).compareTo(o2.getValue()) < Constants.NUMBER_ZERO) {
                val = Constants.NUMBER_ONE;
            } else if ((o1.getKey().compareTo(o2.getKey()) < Constants.NUMBER_ZERO)) {
                val = -Constants.NUMBER_ONE;
            }
            return val;
        });
        for (Map.Entry<String, Integer> aa : list) {
            String curLine = aa.getKey()+" " + aa.getValue();
            ansList.add(curLine);
        }
        return ansList;
    }

}
