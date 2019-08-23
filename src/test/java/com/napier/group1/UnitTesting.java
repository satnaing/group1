package com.napier.group1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTesting {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

//    @Test
//    void displayCountry()
//    {
//        app.displayCountry(null);
//    }

    @Test
    void CountriesInContinent()
    {
        ArrayList<Country> c= new ArrayList<Country>();
        app.displayCountryContinent(c);
    }
}
