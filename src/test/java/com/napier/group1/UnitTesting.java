package com.napier.group1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTesting {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void testGetCountry()
    {
        Country c1 = app.getCountry();
    }

    @Test
    void displayCountry()
    {
        app.displayCountry(null);
    }

    @Test
    void testGetCountryContinent()
    {
        app.getCountryInContinent();
    }

    @Test
    void testCountriesInContinent()
    {
        ArrayList<Country> c= new ArrayList<Country>();
        app.displayCountryContinent(c);
    }

    @Test
    void testGetCountryInRegion()
    {
        app.getCountryInRegion();
    }

    @Test
    void testDisplayCountryInRegion()
    {
        ArrayList<Country> c= new ArrayList<Country>();
        app.displayCountryInRegion(null);
    }

    @Test
    void testGetSpecificCity(){
        app.getSpecificCity(123);
    }

    @Test
    void testGetCity(){
        app.getCity();
    }

    @Test
    void testGetCitiesContinent(){
        app.getCitiesContinent();
    }


    @Test
    void testGetCitiesRegion(){
        app.getCitiesRegion();
    }


    @Test
    void testgetCitiesDistrict(){
        app.getCitiesDistrict();
    }


    @Test
    void testgetCitiesCountry(){
        app.getCitiesCountry();
    }


    @Test
    void testgetCapitalWorld(){
        app.getCapitalWorld();
    }


    @Test
    void testgetCapitalContinent(){
        app.getCapitalContinent();
    }


    @Test
    void testgetCapitalRegion(){
        app.getCapitalRegion();
    }


    @Test
    void testtotalPopuRegion(){
        app.totalPopuRegion(null);
    }


    @Test
    void testPopulationLivingInCitiesRegion(){
        app.populationLivingInCitiesRegion(null);
    }


    @Test
    void testpopulationRgn(){
        int total = app.totalPopuRegion("Southeast Asia");
        int liveCities = app.populationLivingInCitiesRegion("Southeast Asia");
        app.populationRgn(total, liveCities, "Southeast Asia");
    }


    @Test
    void testtotalPopuContinent(){
        app.totalPopuContinent(null);
    }


    @Test
    void testpopulationLivingInCitiesContinent(){
        app.populationLivingInCitiesContinent(null);
    }


    @Test
    void populationContinent(){
        String continent = "Asia";
        double totalPopuCon = app.totalPopuContinent(continent);
        double liveCitiesCon = app.populationLivingInCitiesContinent(continent);
        app.populationContinent(totalPopuCon, liveCitiesCon, continent);
    }


    @Test
    void testtotalPopuCountry(){
        app.totalPopuCountry(null);
    }


    @Test
    void testPopulationLivingInCitiesCountry(){
        app.populationLivingInCitiesCountry(null);
    }


    @Test
    void testPopulationCountry(){
        double totalPopuCountry = app.totalPopuCountry("Myanmar");
        double liveCitiesCountry = app.populationLivingInCitiesCountry("Myanmar");
        app.populationCountry(totalPopuCountry, liveCitiesCountry, "Myanmar"   );
    }
//    getCitiesDistrict
//            getCitiesCountry
//    getCapitalWorld
//            getCapitalContinent
//    getCapitalRegion
//            totalPopuRegion
//    populationLivingInCitiesRegion
//            populationRgn
//    totalPopuContinent
//            populationLivingInCitiesContinent
//    populationContinent
//            totalPopuCountry
//    populationLivingInCitiesCountry
//            populationCountry


//    @Test
//    void bla()
//    {
//        app.getCitiesCountry("Myanmar");
//    }
}
