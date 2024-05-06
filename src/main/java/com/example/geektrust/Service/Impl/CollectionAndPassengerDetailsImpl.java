package com.example.geektrust.Service.Impl;

import com.example.geektrust.Model.Destination;
import com.example.geektrust.Model.Journey;
import com.example.geektrust.Model.MetroCard;
import com.example.geektrust.Model.PassengerCount;
import com.example.geektrust.Service.CollectionAndPassengerDetails;

import java.util.ArrayList;
import java.util.List;

public class CollectionAndPassengerDetailsImpl implements CollectionAndPassengerDetails {

    private static final int KID_FAIR=50;
    private static final int ADULT_FAIR=200;
    private static final int SENIOR_CITIZEN=100;

    public List<String> calculateCollection(List <MetroCard> metroCardList, List <Journey> journeyList) {
        List <Integer> collectedAmount = new ArrayList<>(List.of(0,0));
        List <Integer> collectedDiscountAmount = new ArrayList<>(List.of(0,0));
        List <PassengerCount> passengerCountList = new ArrayList<>(List.of(new PassengerCount(),new PassengerCount()));
        for (Journey journey : journeyList) {
            String curPassenger = journey.getPassenger();
            Destination curDestination = journey.getDestination();
            int fairAmount = 0;
            List<Integer> ansList ;
            MetroCard curMetroCard = null;
            int curFair , curDiscount;
            if (curPassenger.equals("KID")) {
                fairAmount = KID_FAIR;
            } else if (curPassenger.equals("ADULT")) {
                fairAmount = ADULT_FAIR;
            } else if (curPassenger.equals("SENIOR_CITIZEN")) {
                fairAmount = SENIOR_CITIZEN;
            }
            for (MetroCard metroCard : metroCardList) {
                if (journey.getMetroCardId().equals(metroCard.getMetroCardID())) {
                    curMetroCard = metroCard;
                }
            }
            if (curDestination.equals(Destination.CENTRAL)) {
                ansList = init(curPassenger, fairAmount, curMetroCard, passengerCountList.get(0));
                curFair = curMetroCard.calculateAmount(ansList.get(0));
                curDiscount = ansList.get(1);
                collectedAmount.set(0, collectedAmount.get(0) + curFair);
                collectedDiscountAmount.set(0, collectedDiscountAmount.get(0) + curDiscount);
            } else if (curDestination.equals(Destination.AIRPORT)) {
                ansList = init(curPassenger, fairAmount, curMetroCard, passengerCountList.get(1));
                curFair = curMetroCard.calculateAmount(ansList.get(0));
                curDiscount = ansList.get(1);
                collectedAmount.set(1, collectedAmount.get(1) + curFair);
                collectedDiscountAmount.set(1, collectedDiscountAmount.get(1) + curDiscount);
            }
        }
        return createResultList(collectedAmount,collectedDiscountAmount,passengerCountList);
    }



    public ArrayList<Integer> init(String passengerType, int fairAmount, MetroCard curMetroCard, PassengerCount passengerCount) {
        int ticketAmount,discountAmount=0;
        if(curMetroCard.getPassengerCount(passengerType)>0) {
            ticketAmount=fairAmount/2;
            discountAmount=fairAmount/2;
            curMetroCard.changePassengerCount(passengerType,-1);
        }
        else {
            ticketAmount=fairAmount;
            curMetroCard.changePassengerCount(passengerType,+1);
        }
        passengerCount.increasePassengerCount(passengerType);
        return new ArrayList<>(List.of(ticketAmount,discountAmount));
    }

    public List <String> createResultList(List <Integer> collectedAmount,List <Integer> collectedDiscountAmount,
                                          List <PassengerCount> passengerCountList) {
        List <String> ansList=new ArrayList<>();
        ansList.add("TOTAL_COLLECTION "+Destination.CENTRAL+" "+collectedAmount.get(0)+" "+collectedDiscountAmount.get(0));
        ansList.add("PASSENGER_TYPE_SUMMARY");
        ansList=getPassenegrCount(ansList,passengerCountList.get(0));
        ansList.add("TOTAL_COLLECTION "+Destination.AIRPORT+" "+collectedAmount.get(1)+" "+collectedDiscountAmount.get(1));
        ansList.add("PASSENGER_TYPE_SUMMARY");
        ansList=getPassenegrCount(ansList,passengerCountList.get(1));
        return ansList;
    }

    public List<String> getPassenegrCount(List <String> ansList,PassengerCount passengerCount) {
        if(passengerCount.getKidsCount()>0) {
            String curLine="KID "+ passengerCount.getKidsCount();
            ansList.add(curLine);
        }
        if(passengerCount.getAdultCount()>0) {
            String curLine="ADULT "+ passengerCount.getAdultCount();
            ansList.add(curLine);
        }
        if(passengerCount.getSeniorCitizenCount()>0) {
            String curLine="SENIOR_CITIZEN "+ passengerCount.getSeniorCitizenCount();
            ansList.add(curLine);
        }
        return ansList;
    }

}
