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
        app.connect("localhost:33060");
    }

    @Test
    void testCountryInReg()
    {
        ArrayList<Country> countryInReg = app.getCountryInRegion("Southeast Asia", 99999);
        app.displayCountryInRegion(countryInReg);
    }

    @Test
    void testTotalWorldPop()
    {
        app.totalWorldPop();
    }

//    @Test
//    void testMainDisplay()
//    {
//        app.mainDisplay();
//    }
//
//    @Test
//    void testAskContinent()
//    {
//        app.askContinent();
//    }
//
//    @Test
//    void testAskRegion()
//    {
//        app.askRegion();
//    }
//
//    @Test
//    void testAskCountry()
//    {
//        app.askCountry();
//    }

//    @Test
//    void testGetCountry()
//    {
//        Country c1 = app.getCountry(99999);
//    }

//    @Test
//    void displayCountry()
//    {
//        app.displayCountry(null);
//    }

    @Test
    void testCountriesInContinent()
    {
        ArrayList<Country> c= new ArrayList<Country>();
        app.displayCountryContinent(c);
    }


    @Test
    void testGetCountryInRegion()
    {
        app.getCountryInRegion(null, 99999);
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
        app.getCity(89);
    }

    @Test
    void testGetCitiesContinent(){
        app.getCitiesContinent ("Asia", 99999);
    }


    @Test
    void testGetCitiesRegion(){
        app.getCitiesRegion("Caribbean", 99999);
    }


    @Test
    void testgetCitiesDistrict(){
        app.getCitiesDistrict(99999);
    }


    @Test
    void testgetCitiesCountry(){
        app.getCitiesCountry("England", 99999);
    }


    @Test
    void testgetCapitalWorld(){
        app.getCapitalWorld(99999);
    }


    @Test
    void testgetCapitalContinent(){
        app.getCapitalContinent("Asia", 99999);
    }
//

    @Test
    void testgetCapitalRegion(){
        app.getCapitalRegion("Caribbean", 99999);
    }

//
    @Test
    void testtotalPopuRegion(){
        app.totalPopuRegion(null);
    }
//
//
    @Test
    void testPopulationLivingInCitiesRegion(){
        app.populationLivingInCitiesRegion(null);
    }
//
//
    @Test
    void testpopulationRgn(){
        int total = app.totalPopuRegion(null);
        int liveCities = app.populationLivingInCitiesRegion("Southeast Asia");
        app.populationRgn(total, liveCities, "Southeast Asia");
    }
//
//
    @Test
    void testtotalPopuContinent(){
        app.totalPopuContinent(null);
    }
//
//
    @Test
    void testpopulationLivingInCitiesContinent(){
        app.populationLivingInCitiesContinent(null);
    }
//
//
    @Test
    void populationContinent(){
        String continent = "Asia";
        double totalPopuCon = app.totalPopuContinent(null);
        double liveCitiesCon = app.populationLivingInCitiesContinent(continent);
        app.populationContinent(totalPopuCon, liveCitiesCon, continent);
    }
//
//
    @Test
    void testtotalPopuCountry(){
        app.totalPopuCountry(null);
    }
//
//
    @Test
    void testPopulationLivingInCitiesCountry(){
        app.populationLivingInCitiesCountry(null);
    }
//
//
    @Test
    void testPopulationCountry(){
        double totalPopuCountry = app.totalPopuCountry(null);
        double liveCitiesCountry = app.populationLivingInCitiesCountry("Myanmar");
        app.populationCountry(totalPopuCountry, liveCitiesCountry, "Myanmar"   );
    }


//    @Test
//    void bla()
//    {
//        app.getCitiesCountry("Myanmar");
//    }
}
