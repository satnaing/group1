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
    void testInteGetCity()
    {
        City cty = app.getCity(1);
        assertEquals(cty.getID(), 1);
        assertEquals(cty.getName(), "Kabul");
        assertEquals(cty.getPopulation(), 1780000);
    }
}
