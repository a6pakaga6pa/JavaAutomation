package javaCollections.mainTask.models;

public class Car {

    private String type;
    private String model;
    private int carCost;
    private int maxSpeed;
    private int fuelConsumption;

    public Car(String type, String model, int carCost, int maxSpeed, int fuelConsumption) {
        this.type = type;
        this.model = model;
        this.carCost = carCost;
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumption;
    }

    public Car() {
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }


    public int getCarCost() {
        return carCost;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", carCost=" + carCost +
                ", maxSpeed=" + maxSpeed +
                ", fuelConsumption=" + fuelConsumption +
                '}';
    }
}