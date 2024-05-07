package com.example.geektrust.Service.Impl;

import com.example.geektrust.Model.Constants;
import com.example.geektrust.Model.Destination;
import com.example.geektrust.Model.PassengerCount;
import com.example.geektrust.Service.PrintSummary;

import java.util.*;

public class PrintSummaryImpl implements PrintSummary {
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

    private List<String> getPassenegrCount(List<String> ansList, PassengerCount passengerCount) {
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
