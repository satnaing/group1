package com.napier.group1;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App
{
    public static void main(String[] args) throws IOException {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Display Top Populated countries in the world
        a.getCountry();

        // Display Top Populated countries in a continent
        a.getCountryInContinent();

        // Display Top Populated countries in a continent
        a.getCountryInContinent();

        // Display Top Populated countries in a region
        a.getCountryInRegion();

        // Disconnect from database
        a.disconnect();
    }


    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public World getCountry()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Population "
                            + "FROM country "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Check one is returned

            while (rset.next()){
                World wd = new World();
                wd.Name = rset.getString("Name");
                wd.Population = rset.getInt("Population");
                System.out.println(
                    "Country:" + wd.Name + "\n" +
                        "Population: " + wd.Population + "\n");
            }
            return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public World getCountryInContinent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create Asia string for SQL statement
            String strCont =
                    "SELECT Name, Population "
                            + "FROM country WHERE continent = 'Asia' "
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet rsetStr = stmt.executeQuery(strCont);
            // Check one is returned

            // Displaying Countries of Asia Continent
            System.out.println("Continent : Asia");
            System.out.println("-----------------");
            while (rsetStr.next()){
                World wd = new World();
                wd.Name = rsetStr.getString("Name");
                wd.Population = rsetStr.getInt("Population");
                System.out.println(
                        "Country:" + wd.Name + "\n" +
                                "Population: " + wd.Population + "\n");
            }
            System.out.println("-----------------"+ "\n");

            return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details" + e);
            return null;
        }
    }

    public World getCountryInRegion()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create Asia string for SQL statement
            String strCont =
                    "SELECT Name, Population "
                            + "FROM country WHERE Region = 'Southeast Asia' "
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet rsetStr = stmt.executeQuery(strCont);
            // Check one is returned

            // Displaying Countries of Asia Continent
            System.out.println("Region : Southeast Asia");
            System.out.println("-----------------");
            while (rsetStr.next()){
                World wd = new World();
                wd.Name = rsetStr.getString("Name");
                wd.Population = rsetStr.getInt("Population");
                System.out.println(
                        "Country:" + wd.Name + "\n" +
                                "Population: " + wd.Population + "\n");
            }
            System.out.println("-----------------"+ "\n");

            return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details" + e);
            return null;
        }
    }
//    public void displayCountry(World wd)
//    {
//        if (wd != null)
//        {
//            System.out.println(
//                    "Country:" + wd.Name + "\n" +
//                            "Population: " + wd.Population + "\n");
//        }
//    }
}