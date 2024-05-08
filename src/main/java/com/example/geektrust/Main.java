package com.example.geektrust;

import com.example.geektrust.Service.Impl.MetroServiceImpl;
import com.example.geektrust.Service.MetroService;

public class Main {
    public static void main(String[] args)  {
        MetroService metroService=new MetroServiceImpl();
        metroService.findCollectionAndDiscount(args[0]);
	}
}
