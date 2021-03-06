package com.company;

import com.company.dto.Car;
import com.company.dto.Manufacturer;
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
        Manufacturer manufacturer1 = new Manufacturer("VW", 1937, "Germany");
        Manufacturer manufacturer2 = new Manufacturer("Toyota", 1937, "Japan");
        Manufacturer manufacturer3 = new Manufacturer("Lamborghini", 1963, "Italy");

        List<Manufacturer> list1 = Collections.singletonList(manufacturer1);
        List<Manufacturer> list2 = Arrays.asList(manufacturer1, manufacturer2);
        List<Manufacturer> list3 = Arrays.asList(manufacturer1, manufacturer2, manufacturer3);

        Car car1 = new Car("car1", "aaa", 15.52, 2014, list1, EngineType.S6);
        Car car2 = new Car("car2", "hhh", 25.52, 1996, list2, EngineType.V12);
        Car car3 = new Car("car3", "ccc", 25.52, 1994, list3, EngineType.S6);
        Car car4 = new Car("car4", "zzz", 25.52, 2019, list1, EngineType.V12);
        Car car5 = new Car("car5", "lll", 45.52, 2014, list2, EngineType.S6);
        Car car6 = new Car("car6", "qqq", 25.52, 2001, list3, EngineType.S6);
        Car car7 = new Car("car7", "abc", 25.52, 2012, list3, EngineType.S6);

        List<Car> carsToAdd = Arrays.asList(car1, car2, car3, car4, car5, car6);

        CarService carService = new CarServiceImpl();

        carService.addCars(carsToAdd);

        carService.addCar(car7);

        carService.getCars().forEach(System.out::println);

        carService.removeCar(car6);

        System.out.println();
        carService.getCars().forEach(System.out::println);

        System.out.println();
        carService.getCarsWithV12().forEach(System.out::println);

        System.out.println();
        carService.getCarsProducedBefore1999().forEach(System.out::println);

        System.out.println();
        System.out.println(carService.getTheMostExpensiveCar());

        System.out.println();
        System.out.println(carService.getTheCheapestCar());

        System.out.println();
        carService.getCarsWithAtLeast3Manufacturers().forEach(System.out::println);

        System.out.println();
        carService.getCarsSortedBy(SortingOption.MODEL_DESC).forEach(System.out::println);

        System.out.println();
        System.out.println(carService.isCarSaved(car7));
        System.out.println(carService.isCarSaved(car6));

        System.out.println();
        carService.getCarsByManufacturer(manufacturer2).forEach(System.out::println);

        System.out.println();
        carService.getCarsByPeriod(Period.AFTER, 2012).forEach(System.out::println);
    }
}
