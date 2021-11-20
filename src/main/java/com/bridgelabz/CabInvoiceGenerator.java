package com.bridgelabz;

public class CabInvoiceGenerator {

    //assigned cost for Cab Ride
    private static final int COST_PER_MINUTE = 1;
    private static final double COST_PER_KILOMETER = 10.0;
    private static final double MINIMUM_FARE = 5.0;

    //assigned cost for normal Cab Ride
    private static final double COST_PER_KILOMETER_NORMAL = 10.0;
    private static final double COST_PER_MINUTE_NORMAL = 1;
    private static final double MINIMUM_FARE_NORMAL = 5.0;

    //assigned cost for Cab Ride
    private static final double MINIMUM_COST_PER_KILOMETER_PREMIUM = 15.0;
    private static final double COST_PER_MINUTE_PREMIUM = 2.0;
    private static final double MINIMUM_FARE_PREMIUM = 20.0;

    double totalFare = 0.0;

    //calculating fare for a Cab ride
    public double calculateFare(double distance, int time) {
        double totalFare =  distance * COST_PER_KILOMETER + time * COST_PER_MINUTE;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    //calculating fare for multiple cab ride
    public double calculateTotalFare(CabRide[] rides) {
//        double totalFare = 0.0;
        for (CabRide ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }

    //calculating fare for Normal or Premium ride
    public double calculateFare(double distance, int time, String type) {
        if (type.equalsIgnoreCase("Normal")) {
            double totalFare = distance * COST_PER_KILOMETER_NORMAL + time * COST_PER_MINUTE_NORMAL;
            return Math.max(totalFare, MINIMUM_FARE_NORMAL);
        }
        else if (type.equalsIgnoreCase("Premium")) {
            double totalFare = distance * MINIMUM_COST_PER_KILOMETER_PREMIUM + time * COST_PER_MINUTE_PREMIUM;
            return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
        }
        else {
            return 0;
        }
    }

    //calculating fare for multiple Normal or Premium ride
    public double calculateFare(CabRide[] rides, String type) {
//        double totalFare = 0.0;
        if (type.equalsIgnoreCase("Normal")) {
            for (CabRide ride : rides) {
                totalFare += calculateFare(ride.getDistance(), ride.getTime(), type);
            }
            return totalFare;

        }
        else if (type.equalsIgnoreCase("Premium")) {
            for (CabRide ride : rides) {
                totalFare += calculateFare(ride.getDistance(), ride.getTime(), type);
            }
            return totalFare;
        }
        return 0;
    }
}

