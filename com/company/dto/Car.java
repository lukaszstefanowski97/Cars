package com.company.dto;

import com.company.enums.EngineType;

import java.util.List;
import java.util.Objects;

public class Car {

    String name;
    String model;
    Double price;
    Integer productionYear;
    List<Manufacturer> manufacturers;
    EngineType engineType;

    public Car(String name, String model, Double price, Integer productionYear, List<Manufacturer> manufacturers, EngineType engineType) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.productionYear = productionYear;
        this.manufacturers = manufacturers;
        this.engineType = engineType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(List<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(model, car.model) &&
                Objects.equals(price, car.price) &&
                Objects.equals(productionYear, car.productionYear) &&
                Objects.equals(manufacturers, car.manufacturers) &&
                engineType == car.engineType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, manufacturers);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", productionYear=" + productionYear +
                ", manufacturers=" + manufacturers +
                ", engineType=" + engineType +
                '}';
    }
}
