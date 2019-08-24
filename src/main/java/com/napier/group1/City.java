package com.napier.group1;

import java.sql.*;

public class City {
    // Connection to MySQL database
    private Country country;

    private int ID;

    private String Name;

    public City() {
    }

    public City(Country country, int ID, String name, String district) {
        this.country = country;
        this.ID = ID;
        Name = name;
        District = district;
    }

    @Override
    public String toString() {
        return "City{" +
                "country=" + country +
                ", ID=" + ID +
                ", Name='" + Name + '\'' +
                ", District='" + District + '\'' +
                '}';
    }

    private String District;

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
}
