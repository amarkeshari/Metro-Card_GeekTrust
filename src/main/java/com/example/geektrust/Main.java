package com.example.geektrust;

import com.example.geektrust.Service.Impl.MetroServiceImpl;
import com.example.geektrust.Service.MetroService;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MetroService metroService=new MetroServiceImpl();
        metroService.findCollectionAndDiscount(args[0]);
	}
}
