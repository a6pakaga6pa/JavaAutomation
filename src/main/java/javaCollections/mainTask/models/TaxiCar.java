package javaCollections.mainTask.models;

import javaCollections.mainTask.cars.PassengerCarTypes;

public class TaxiCar extends Car{

    public TaxiCar(String model, int carCost, int maxSpeed, int fuelConsumption) {
        super(PassengerCarTypes.TAXI_CAR.toString(), model, carCost, maxSpeed, fuelConsumption);
    }

    @Override
    public String toString() {
        return "TaxiCar{" +
                "type=" + getType() +
                ", model='" + getModel() + '\'' +
                ", carCost=" + getCarCost() +
                ", maxSpeed=" + getMaxSpeed() +
                ", fuelConsumption=" + getFuelConsumption() +
                '}';
    }
}
