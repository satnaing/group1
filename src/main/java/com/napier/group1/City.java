package com.napier.group1;

import java.sql.*;

public class City {
    private Country country;

    private int ID;

    private String Name;

    private String District;

    private int Population;

    public City() {
    }

    public City(Country country, int ID, String name, String district, int population) {
        this.country = country;
        this.ID = ID;
        Name = name;
        District = district;
        Population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "country=" + country +
                ", ID=" + ID +
                ", Name='" + Name + '\'' +
                ", District='" + District + '\'' +
                ", Population=" + Population +
                '}';
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int population) {
        Population = population;
    }
}