package com.napier.group1;

public class Country {
    private String Code;

    private String Name;

    private String Continent;

    private String Region;

    private int Population;

    private String Capital;

    public Country(String code, String name, String continent, String region, int population, String capital) {
        Code = code;
        Name = name;
        Continent = continent;
        Region = region;
        Population = population;
        Capital = capital;
    }

    public Country() {
    }

    @Override
    public String toString() {
        return "Country{" +
                "Code='" + Code + '\'' +
                ", Name='" + Name + '\'' +
                ", Continent='" + Continent + '\'' +
                ", Region='" + Region + '\'' +
                ", Population=" + Population +
                ", Capital='" + Capital + '\'' +
                '}';
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContinent() {
        return Continent;
    }

    public void setContinent(String continent) {
        Continent = continent;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int population) {
        Population = population;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }
}