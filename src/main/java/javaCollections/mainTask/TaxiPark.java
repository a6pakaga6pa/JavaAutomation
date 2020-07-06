package javaCollections.mainTask;

import com.google.gson.Gson;
import javaCollections.mainTask.models.TaxiCar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class TaxiPark {

    private List<TaxiCar> taxiCars;
    private static String jsonFilePath = "src/main/resources/taxiCars.json";

    public TaxiPark(List<TaxiCar> cars) {
        this.taxiCars = cars;
    }

    public List<TaxiCar> getTaxiCars() {
        return taxiCars;
    }

    public int totalCarsCost(TaxiPark taxiPark){
        List<TaxiCar> cars = taxiPark.taxiCars;
        int totalCost = 0;
        for (TaxiCar car: cars) {
            totalCost += car.getCarCost();
        }
        return totalCost;
    }

    public List<TaxiCar> sortByFuelConsumption(TaxiPark taxiPark) {
        List<TaxiCar> cars = taxiPark.taxiCars;
        cars.sort((o1, o2) -> o1.getFuelConsumption() - o2.getFuelConsumption());
        return cars;

    }

    public List<TaxiCar> findCarsWithSpeedRange(TaxiPark taxiPark, int minSpeed, int maxSpeed) {
        List<TaxiCar> cars = taxiPark.taxiCars;
        return cars.stream().filter(c -> c.getMaxSpeed() > minSpeed && c.getMaxSpeed() < maxSpeed).collect(Collectors.toList());
    }

    public static TaxiPark loadListFromJson() {
        String jsonString = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            while(bufferedReader.ready()) {
                jsonString += bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Json file is not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.fromJson(jsonString, TaxiPark.class);
    }

    @Override
    public String toString() {
        return "TaxiPark{" +
                "taxiCars=" + taxiCars +
                '}';
    }
}

