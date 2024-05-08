package com.example.geektrust.Service.Impl;

import com.example.geektrust.Model.PassengerCount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PrintSummaryImplTest {
    private final PrintSummaryImpl printSummary= new PrintSummaryImpl();

    @Test
    public void testCreateResultList() {
        java.util.List<Integer> collectedAmount= new ArrayList<>();
        List<Integer> collectedDiscountAmount=new ArrayList<>();
        List< PassengerCount > passengerCountList=new ArrayList<>();
        Assertions.assertThrows(IndexOutOfBoundsException.class,()->{
            printSummary.createResultList(collectedAmount,collectedDiscountAmount,passengerCountList);
        });
    }
}
