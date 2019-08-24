package com.napier.group1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void testGetCity()
    {
        City cty = app.getCity(2710);
        assertEquals(cty.getID(), 2710);
        assertEquals(cty.getName(), "Rangoon (Yangon)");
        assertEquals(cty.getPopulation(), 3361700);
    }
}