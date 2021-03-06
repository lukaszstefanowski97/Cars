package com.company.dto;

import com.company.enums.Country;

import java.util.Objects;

public class Manufacturer {

    String name;
    Integer year;
    Country country;

    public Manufacturer(String name, Integer year, Country country) {
        this.name = name;
        this.year = year;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(year, that.year) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", country='" + country + '\'' +
                '}';
    }
}
