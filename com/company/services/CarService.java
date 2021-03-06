package com.company.services;

import com.company.dto.Car;
import com.company.dto.Manufacturer;
import com.company.enums.Period;
import com.company.enums.SortingOption;

import java.util.List;
import java.util.Optional;

public interface CarService {

    void addCar(Car car);

    void addCars(List<Car> cars);

    void removeCar(Car car);

    List<Car> getCars();

    List<Car> getCarsWithV12();

    List<Car> getCarsProducedBefore1999();

    Optional<Car> getTheMostExpensiveCar();

    Optional<Car> getTheCheapestCar();

    List<Car> getCarsWithAtLeast3Manufacturers();

    List<Car> getCarsSortedBy(SortingOption sortingOption);

    boolean isCarSaved(Car car);

    List<Car> getCarsByManufacturer(Manufacturer manufacturer);

    List<Car> getCarsByPeriod(Period period, Integer year);
}
