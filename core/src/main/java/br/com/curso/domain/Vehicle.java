package br.com.curso.domain;

import br.com.curso.exceptions.InvalidLicensePlateException;
import br.com.curso.exceptions.InvalidVinException;
import br.com.curso.exceptions.InvalidYearException;

public class Vehicle {

    private String brand;

    private String model;

    private int year;

    private String licensePlate;

    private String color;

    private String vin; // Vehicle Identification Number

    private User user;




    public void setLicensePlate(String licensePlate) throws InvalidLicensePlateException {
        this.licensePlate = licensePlate;

    }

    public void setVin(String vin) throws InvalidVinException {
        this.vin = vin;

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws InvalidYearException {
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}