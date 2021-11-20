package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator invoiceService = new CabInvoiceGenerator();

    //total fare test
    @Test
    public void givenDistanceAndTime_TotalFare() {

        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    //minimum fare test
    @Test
    public void givenDistanceAndTime_MinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    //multiple fare test
    @Test
    public void givenMultipleRides_TotalFare() {
        CabRide[] rides = {new CabRide(2.0, 5),
                new CabRide(2.0, 5),
        };
        double totalFare = invoiceService.calculateTotalFare(rides);
        Assert.assertEquals(50, totalFare, 0);
    }

    //total fare for premium rides
    @Test
    public void givenDistanceAndTime_PremiumTotalFare() {
        double distance = 5.0;
        int time = 12;
        String type = "premium";
        double fare = invoiceService.calculateFare(distance, time, type);
        Assert.assertEquals(99, fare, 0.0);
    }

    //minimum fare for cab premium ride
    @Test
    public void givenLessDistanceAndTimePremiumMinFare() {
        double distance = 1.1;
        int time = 2;
        String type = "premium";
        double fare = invoiceService.calculateFare(distance, time, type);
        Assert.assertEquals(20.5, fare, 0.0);
    }

    //total fare of multiple Cab premium rides
    @Test
    public void givenMultipleRides_PremiumTotalFare() {
        CabRide[] rides = {new CabRide(2.0, 5),
                new CabRide(0.1, 1)};
        String type = "premium";
        double totalFare = invoiceService.calculateFare(rides, type);
        Assert.assertEquals(60, totalFare, 0.0);
    }

}