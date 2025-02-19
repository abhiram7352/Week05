package org.day02_java_json;

import com.google.gson.Gson;

import java.sql.SQLOutput;

class Car{
    private String Brand;
    private String model;
    private int year;

    //Constructor
    public Car(String brand, String model, int year) {
        Brand = brand;
        this.model = model;
        this.year = year;
    }

    //Using getter and  setter
    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
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

    public void setYear(int year) {
        this.year = year;
    }
}
public class JavaObjectIntoJSONFormat {
    public static void main(String[] args) {

        //Creating car object
        Car car = new Car("Tesla", "EV2025", 2025);

        // Convert Java object to JSON using Gson
        Gson gson = new Gson();
        String json = gson.toJson(car);

        //Print output
        System.out.println(json);
    }
}
