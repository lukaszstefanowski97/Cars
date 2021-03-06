package com.company.services;

import com.company.dto.Car;
import com.company.dto.Manufacturer;
import com.company.enums.EngineType;
import com.company.enums.Period;
import com.company.enums.SortingOption;

import java.util.*;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    List<Car> cars = new LinkedList<>();

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public void addCars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    @Override
    public void removeCar(Car car) {
        cars.remove(car);
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public List<Car> getCarsWithV12() {
        return cars.stream().filter(car -> EngineType.V12.equals(car.getEngineType())).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsProducedBefore1999() {
        return cars.stream().filter(car -> car.getProductionYear() < 1999).collect(Collectors.toList());
    }

    @Override
    public Optional<Car> getTheMostExpensiveCar() {
        return cars.stream().max(Comparator.comparing(Car::getPrice));
    }

    @Override
    public Optional<Car> getTheCheapestCar() {
        return cars.stream().min(Comparator.comparing(Car::getPrice));
    }

    @Override
    public List<Car> getCarsWithAtLeast3Manufacturers() {
        return cars.stream().filter(car -> car.getManufacturers().size() > 2).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsSortedBy(SortingOption sortingOption) {
        List<Car> sortedCars = new LinkedList<>(cars);

        switch (sortingOption) {
            case MODEL_ASC:
                sortedCars.sort(Comparator.comparing(Car::getModel));
                break;
            case MODEL_DESC:
                sortedCars.sort(Comparator.comparing(Car::getModel).reversed());
                break;
            case PRODUCTION_YEAR_ASC:
                sortedCars.sort(Comparator.comparing(Car::getProductionYear));
                break;
            case PRODUCTION_YEAR_DESC:
                sortedCars.sort(Comparator.comparing(Car::getProductionYear).reversed());
                break;
        }

        return sortedCars;
    }

    @Override
    public boolean isCarSaved(Car car) {
        return cars.contains(car);
    }

    @Override
    public List<Car> getCarsByManufacturer(Manufacturer manufacturer) {
        return cars.stream().filter(car -> car.getManufacturers().contains(manufacturer)).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsByManufacturersYearFounded(Period period, Integer year, List<Manufacturer> manufacturers) {
        List<Car> result = new ArrayList<>();

        switch (period) {
            case BEFORE:
                manufacturers.stream()
                        .filter(manufacturer -> manufacturer.getYear() < year).collect(Collectors.toList())
                        .forEach(manufacturer -> result.addAll(getCarsByManufacturer(manufacturer)));
                break;
            case AFTER:
                manufacturers.stream()
                        .filter(manufacturer -> manufacturer.getYear() > year).collect(Collectors.toList())
                        .forEach(manufacturer -> result.addAll(getCarsByManufacturer(manufacturer)));
                break;
            case BEFORE_OR_EQUAL:
                manufacturers.stream()
                        .filter(manufacturer -> manufacturer.getYear() <= year).collect(Collectors.toList())
                        .forEach(manufacturer -> result.addAll(getCarsByManufacturer(manufacturer)));
                break;
            case AFTER_OR_EQUAL:
                manufacturers.stream()
                        .filter(manufacturer -> manufacturer.getYear() >= year).collect(Collectors.toList())
                        .forEach(manufacturer -> result.addAll(getCarsByManufacturer(manufacturer)));
                break;
            case EQUAL:
                manufacturers.stream()
                        .filter(manufacturer -> manufacturer.getYear().equals(year)).collect(Collectors.toList())
                        .forEach(manufacturer -> result.addAll(getCarsByManufacturer(manufacturer)));
                break;
            case NOT_EQUAL:
                manufacturers.stream()
                        .filter(manufacturer -> !manufacturer.getYear().equals(year)).collect(Collectors.toList())
                        .forEach(manufacturer -> result.addAll(getCarsByManufacturer(manufacturer)));
                break;
        }

        return result;
    }
}
