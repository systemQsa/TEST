package com.myproject.entity;

public class Car {
    private long carId;
    private String name;
    private String brand;
    private String carClass;
    private double rental_price;

    public static class CarBuilder {
        private final Car car;

        public CarBuilder() {
            car = new Car();
        }

        public CarBuilder setCarId(long carId) {
            car.carId = carId;
            return this;
        }

        public CarBuilder setName(String name) {
            car.name = name;
            return this;
        }

        public CarBuilder setBrand(String brand) {
            car.brand = brand;
            return this;
        }

        public CarBuilder setCarClass(String carClass) {
            car.carClass = carClass;
            return this;
        }
        public CarBuilder setRentalPrice(double rentalPrice){
            car.rental_price = rentalPrice;
            return this;
        }
        public Car build(){return car;}
    }

}
