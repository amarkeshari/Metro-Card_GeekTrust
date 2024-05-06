package com.example.geektrust.Service.Impl;

import com.example.geektrust.Model.Destination;
import com.example.geektrust.Model.Journey;
import com.example.geektrust.Model.MetroCard;
import com.example.geektrust.Model.PassengerCount;
import com.example.geektrust.Service.CollectionAndPassengerDetails;
import com.example.geektrust.Service.MetroService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MetroServiceImpl implements MetroService {

    private List <MetroCard> metroCardList;
    private List <Journey> journeyList;
    private CollectionAndPassengerDetails collectionAndPassengerDetails;

    public MetroServiceImpl() {
        this.metroCardList=new ArrayList<>();
        this.journeyList=new ArrayList<>();
        this.collectionAndPassengerDetails=new CollectionAndPassengerDetailsImpl();
    }

    public void init(String path) {
        readLineByLine(path);
        printResults(metroCardList,journeyList);
    }

    private void printResults(List <MetroCard> metroCardList,List <Journey> journeyList) {
        List <String> ansList= collectionAndPassengerDetails.calculateCollection(metroCardList,journeyList);
        for(int i=0;i< ansList.size();i++) {
            System.out.println(ansList.get(i)+" ");
        }
    }

    public MetroCard createMetroCard(List <String> curList) {
        return new MetroCard(curList.get(1),Integer.parseInt(curList.get(2)));
    }

    public Journey createJourney(List <String> curList) {
        return new Journey(curList.get(1), curList.get(2), curList.get(3));
    }

    private void readLineByLine(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                String curLine = scanner.nextLine();
                List<String> curList = Arrays.asList(curLine.split("\\s+"));
                if(curList.get(0).equals("BALANCE")) {
                    metroCardList.add(createMetroCard(curList));
                }
                else if(curList.get(0).equals("CHECK_IN")) {
                    journeyList.add(createJourney(curList));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
