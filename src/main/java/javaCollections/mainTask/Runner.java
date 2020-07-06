package javaCollections.mainTask;

import com.google.gson.Gson;
import javaCollections.mainTask.TaxiPark;
import javaCollections.mainTask.models.TaxiCar;

public class Runner {

    public static void main(String[] args) {
        TaxiPark taxiPark = TaxiPark.loadListFromJson();
        System.out.println("Current taxi park is: " + taxiPark);
        System.out.println("Total cost of taxi park cars: " + taxiPark.totalCarsCost(taxiPark));
        System.out.println("Taxi park cars, sorted by fuel consumption: " + taxiPark.sortByFuelConsumption(taxiPark));
        System.out.println("Taxi park cars, that meet given speed range: " + taxiPark.findCarsWithSpeedRange(taxiPark, 145, 223).toString());
    }
}