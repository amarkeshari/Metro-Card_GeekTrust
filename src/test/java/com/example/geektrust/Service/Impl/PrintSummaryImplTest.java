package com.example.geektrust.Service.Impl;

import com.example.geektrust.Model.PassengerCount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintSummaryImplTest {
    private final PrintSummaryImpl printSummary= new PrintSummaryImpl();

    @Test
    public void testCreateResultList() {
        List<Integer> collectedAmount= Arrays.asList(0,0);
        List<Integer> collectedDiscountAmount=Arrays.asList(0,0);
        List< PassengerCount > passengerCountList=Arrays.asList(new PassengerCount(),new PassengerCount());
        List <String> expectedList= Arrays.asList("TOTAL_COLLECTION CENTRAL 0 0", "PASSENGER_TYPE_SUMMARY", "TOTAL_COLLECTION AIRPORT 0 0", "PASSENGER_TYPE_SUMMARY");
        Assertions.assertEquals(printSummary.createResultList(collectedAmount,collectedDiscountAmount,passengerCountList),expectedList);
    }

    @Test
    public void testCreateResultListThrowsException() {
        java.util.List<Integer> collectedAmount= new ArrayList<>();
        List<Integer> collectedDiscountAmount=new ArrayList<>();
        List< PassengerCount > passengerCountList=new ArrayList<>();
        Assertions.assertThrows(IndexOutOfBoundsException.class,()->{
            printSummary.createResultList(collectedAmount,collectedDiscountAmount,passengerCountList);
        });
    }
}
