package com.example.geektrust.Service.Impl;

import com.example.geektrust.EnumAndConstants.Constants;
import com.example.geektrust.Model.Journey;
import com.example.geektrust.Model.MetroCard;
import com.example.geektrust.Service.CollectionAndPassengerDetails;
import com.example.geektrust.Service.MetroService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MetroServiceImpl implements MetroService {

    private final List<MetroCard> metroCardList;
    private final List<Journey> journeyList;
    private final CollectionAndPassengerDetails collectionAndPassengerDetails;

    public MetroServiceImpl() {
        this.metroCardList = new ArrayList<>();
        this.journeyList = new ArrayList<>();
        this.collectionAndPassengerDetails = new CollectionAndPassengerDetailsImpl();
    }

    public void findCollectionAndDiscount(String path) {
        readLineByLine(path);
        printResults(metroCardList, journeyList);
    }

    private void printResults(List<MetroCard> metroCardList, List<Journey> journeyList) {
        List<String> ansList = collectionAndPassengerDetails.calculateCollection(metroCardList, journeyList);
        for (String s : ansList) {
            System.out.println(s + " ");
        }
    }

    public MetroCard createMetroCard(List<String> curList) {
        return new MetroCard(curList.get(Constants.NUMBER_ONE), Integer.parseInt(curList.get(Constants.NUMBER_TWO)));
    }

    public Journey createJourney(List<String> curList) {
        return new Journey(curList.get(Constants.NUMBER_ONE), curList.get(Constants.NUMBER_TWO), curList.get(Constants.NUMBER_THREE));
    }

    private void readLineByLine(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                String curLine = scanner.nextLine();
                List<String> curList = Arrays.asList(curLine.split("\\s+"));
                if (curList.get(Constants.NUMBER_ZERO).equals("BALANCE")) {
                    metroCardList.add(createMetroCard(curList));
                } else if (curList.get(Constants.NUMBER_ZERO).equals("CHECK_IN")) {
                    journeyList.add(createJourney(curList));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
