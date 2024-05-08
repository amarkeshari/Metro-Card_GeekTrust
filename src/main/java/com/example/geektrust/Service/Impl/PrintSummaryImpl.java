package com.example.geektrust.Service.Impl;

import com.example.geektrust.EnumAndConstants.Constants;
import com.example.geektrust.EnumAndConstants.Destination;
import com.example.geektrust.Model.PassengerCount;
import com.example.geektrust.Service.PrintSummary;

import java.util.*;

public class PrintSummaryImpl implements PrintSummary {
    public List<String> createResultList(List<Integer> collectedAmount, List<Integer> collectedDiscountAmount,
                                         List<PassengerCount> passengerCountList) {
        List<String> ansList = new ArrayList<>();
        ansList.add("TOTAL_COLLECTION " + Destination.CENTRAL + " " + collectedAmount.get(Constants.NUMBER_ZERO) + " " + collectedDiscountAmount.get(Constants.NUMBER_ZERO));
        ansList.add("PASSENGER_TYPE_SUMMARY");
        getPassengerCount(ansList, passengerCountList.get(Constants.NUMBER_ZERO));
        ansList.add("TOTAL_COLLECTION " + Destination.AIRPORT + " " + collectedAmount.get(Constants.NUMBER_ONE) + " " + collectedDiscountAmount.get(Constants.NUMBER_ONE));
        ansList.add("PASSENGER_TYPE_SUMMARY");
        getPassengerCount(ansList, passengerCountList.get(Constants.NUMBER_ONE));
        return ansList;
    }

    private void getPassengerCount(List<String> ansList, PassengerCount passengerCount) {
        List<Map.Entry<String, Integer>> list = getEntryList(passengerCount);
        list.sort((o1, o2) -> {
            int doSwap = Constants.NUMBER_ZERO;
            if ((o1.getValue()).compareTo(o2.getValue()) > Constants.NUMBER_ZERO) {
                doSwap = -Constants.NUMBER_ONE;
            } else if ((o1.getValue()).compareTo(o2.getValue()) < Constants.NUMBER_ZERO) {
                doSwap = Constants.NUMBER_ONE;
            } else if ((o1.getKey().compareTo(o2.getKey()) < Constants.NUMBER_ZERO)) {
                doSwap = -Constants.NUMBER_ONE;
            }
            return doSwap;
        });
        for (Map.Entry<String, Integer> aa : list) {
            String curLine = aa.getKey()+" " + aa.getValue();
            ansList.add(curLine);
        }
    }

    private List<Map.Entry<String, Integer>> getEntryList(PassengerCount passengerCount) {
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
        return new LinkedList<>(passengerMap.entrySet());
    }
}
