package javaCollections.mainTask.models;
import javaCollections.mainTask.cars.PassengerCarTypes;

public class PrivateCar extends Car {
   private PassengerCarTypes type;

   public PrivateCar(String model, int carCost, int maxSpeed, int fuelConsumption) {
      super(PassengerCarTypes.PRIVATE_CAR.toString(), model, carCost, maxSpeed, fuelConsumption);
   }

   @Override
   public String toString() {
      return "PrivateCar{" +
              "type=" + getType() +
              ", model='" + super.getModel() + '\'' +
              ", carCost=" + super.getCarCost() +
              ", maxSpeed=" + super.getMaxSpeed() +
              ", fuelConsumption=" + super.getFuelConsumption() +
              '}';
   }
}