package com.napier.group1;

import java.sql.*;

public class City {
    private Country country;

    private int ID;

    private String Name;

    private String District;

    private int Population;

    private String CountryCode;

    private String CountryName;

    public City() {
    }

    public City(Country country, int ID, String name, String district, int population, String countryCode, String countryName) {
        this.country = country;
        this.ID = ID;
        Name = name;
        District = district;
        Population = population;
        CountryCode = countryCode;
        CountryName = countryName;
    }

    @Override
    public String toString() {
        return "City{" +
                "country=" + country +
                ", ID=" + ID +
                ", Name='" + Name + '\'' +
                ", District='" + District + '\'' +
                ", Population=" + Population +
                ", CountryCode='" + CountryCode + '\'' +
                ", CountryName='" + CountryName + '\'' +
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

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }
}