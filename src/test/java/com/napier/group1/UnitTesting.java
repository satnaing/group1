package com.napier.group1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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


    @Test
    void testGetCitiesDistrict()
    {
        app.getCitiesDistrict("Mandalay", 99999);
        app.getCitiesDistrict("Mandalay", 2);
    }


    @Test
    void testCountryLanguage()
    {
        app.countryLanguage();
    }


    @Test
    void testGetCountry()
    {
        app.getCountry(3);
        app.getCountry(99999);
    }


//    @Test
//    void testDisplayCountry()
//    {
//        Country c1=app.getCountry(5);
//        app.displayCountry(c1);
//    }


    @Test
    void testGetCountryInContinent()
    {
        app.getCountryInContinent("Asia", 4);
        app.getCountryInContinent("Asia", 99999);
    }


    @Test
    void testDisplayCountryInContinent()
    {
        ArrayList<Country> c = app.getCountryInContinent("Europe", 99999);
        app.displayCountryContinent(c);
    }


    @Test
    void testGetCitiesCountry()
    {
        app.getCitiesCountry("Myanmar", 3);
        app.getCitiesCountry("Myanmar", 99999);
    }


    @Test
    void testTotalPopuRegion()
    {
        app.totalPopuRegion("Southeast Asia");
    }


    @Test
    void testTotalPopuContinent()
    {
        app.totalPopuContinent("Asia");
    }


    @Test
    void testTotalPopuCountry()
    {
        app.totalPopuCountry("Myanmar");
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
        app.getCountryInRegion("Southeast Asia", 4);
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
    void testGetCity()
    {
        app.getCity(89);
        app.getCity(99999);
    }

    @Test
    void testGetCitiesContinent()
    {
        app.getCitiesContinent("Asia", 4);
        app.getCitiesContinent ("Asia", 99999);
    }


    @Test
    void testGetCitiesRegion()
    {
        app.getCitiesRegion("Caribbean", 3);
        app.getCitiesRegion("Caribbean", 99999);
    }


//    @Test
//    void testgetCitiesDistrict(){
//        app.getCitiesDistrict(99999);
//    }


    @Test
    void testgetCitiesCountry(){
        app.getCitiesCountry("England", 99999);
    }


    @Test
    void testgetCapitalWorld()
    {
        app.getCapitalWorld(2);
        app.getCapitalWorld(99999);
    }


    @Test
    void testgetCapitalContinent()
    {
        app.getCapitalContinent("Asia", 3);
        app.getCapitalContinent("Asia", 99999);
    }
//

    @Test
    void testgetCapitalRegion()
    {
        app.getCapitalRegion("Caribbean", 5);
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


    @Test
    void testPopulationCountry(){
        double totalPopuCountry = app.totalPopuCountry(null);
        double liveCitiesCountry = app.populationLivingInCitiesCountry("Myanmar");
        app.populationCountry(totalPopuCountry, liveCitiesCountry, "Myanmar"   );
    }


    @Test
    void testPopulationDistrict(){
        app.totalPopuDistrict("Mandalay");
    }


    @Test
    void testPopulationCity(){
        app.totalPopuCity("Mandalay");
    }


    // Failure Tests
    @AfterAll
    @Test
    static void failureTest()
    {
        app.disconnect();
        app.totalWorldPop();
        app.countryLanguage();
        app.getCountry(3);
        app.getCountryInContinent("Asia", 99999);
        ArrayList<Country> c = null;
        app.displayCountryContinent(c);
        app.getCountryInRegion(null, 99999);
        app.getSpecificCity(123);
        app.getCity(99999);
        app.getCitiesContinent ("Asia", 99999);
        app.getCitiesCountry("Myanmar", 3);
        app.getCapitalWorld(2);
        app.getCapitalContinent("Asia", 3);
        app.getCapitalRegion("Caribbean", 5);
        app.totalPopuRegion("Southeast Asia");
        app.populationLivingInCitiesRegion(null);
        app.getCitiesRegion("Caribbean", 3);
        app.totalPopuContinent("Asia");
        app.populationLivingInCitiesContinent(null);
        app.totalPopuCountry("Myanmar");
        app.populationLivingInCitiesCountry(null);
        app.totalPopuDistrict("Mandalay");
        app.totalPopuCity("Mandalay");
        app.getCitiesDistrict("Mandalay", 2);
    }
}
