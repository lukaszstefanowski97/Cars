package com.company;

import com.company.dto.Car;
import com.company.dto.Manufacturer;
import com.company.enums.Country;
import com.company.enums.EngineType;
import com.company.enums.Period;
import com.company.enums.SortingOption;
import com.company.services.CarService;
import com.company.services.CarServiceImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Manufacturer volkswagen = new Manufacturer("VW", 1937, Country.GERMANY);
        Manufacturer toyota = new Manufacturer("Toyota", 1937, Country.JAPAN);
        Manufacturer lamborghini = new Manufacturer("Lamborghini", 1963, Country.ITALY);

        List<Manufacturer> list1 = Collections.singletonList(volkswagen);
        List<Manufacturer> list2 = Arrays.asList(volkswagen, toyota);
        List<Manufacturer> list3 = Arrays.asList(volkswagen, toyota, lamborghini);

        Car car1 = new Car("car1", "aaa", 15.52, 2014, list1, EngineType.S6);
        Car car2 = new Car("car2", "hhh", 25.52, 1996, list2, EngineType.V12);
        Car car3 = new Car("car3", "ccc", 25.52, 1994, list3, EngineType.S6);
        Car car4 = new Car("car4", "zzz", 25.52, 2019, list1, EngineType.V12);
        Car car5 = new Car("car5", "lll", 45.52, 2014, list2, EngineType.S6);
        Car car6 = new Car("car6", "qqq", 25.52, 2001, list3, EngineType.S6);
        Car car7 = new Car("car7", "abc", 25.52, 2012, list3, EngineType.S6);

        CarService carService = new CarServiceImpl();

        carService.addCars(Arrays.asList(car1, car2, car3, car4, car5, car6));

        carService.addCar(car7);

        System.out.println("\nAll cars:");
        carService.getCars().forEach(System.out::println);

        carService.removeCar(car6);

        System.out.println("\nAll cars after removing car6:");
        carService.getCars().forEach(System.out::println);

        System.out.println("\nCars with V12");
        carService.getCarsWithV12().forEach(System.out::println);

        System.out.println("\nCars produced before 1999:");
        carService.getCarsProducedBefore1999().forEach(System.out::println);

        System.out.println("\nThe most expensive car:");
        System.out.println(carService.getTheMostExpensiveCar());

        System.out.println("\nThe cheapest car:");
        System.out.println(carService.getTheCheapestCar());

        System.out.println("\nCars with at least 3 manufacturers:");
        carService.getCarsWithAtLeast3Manufacturers().forEach(System.out::println);

        System.out.println("\nCars sorted by model descending");
        carService.getCarsSortedBy(SortingOption.MODEL_DESC).forEach(System.out::println);

        System.out.println("\nAre cars saved:");
        System.out.println(carService.isCarSaved(car7));
        System.out.println(carService.isCarSaved(car6));

        System.out.println("\nCars by Toyota:");
        carService.getCarsByManufacturer(toyota).forEach(System.out::println);

        System.out.println("\nCars by period:");
        carService.getCarsByManufacturersYearFounded(Period.AFTER, 1950, list3).forEach(System.out::println);
    }
}
