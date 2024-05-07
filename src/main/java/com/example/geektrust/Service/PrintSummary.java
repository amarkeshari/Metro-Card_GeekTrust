package com.example.geektrust.Service;

import com.example.geektrust.Model.PassengerCount;

import java.util.List;

public interface PrintSummary {
    public List<String> createResultList(List<Integer> collectedAmount, List<Integer> collectedDiscountAmount,
                                         List<PassengerCount> passengerCountList);
}
