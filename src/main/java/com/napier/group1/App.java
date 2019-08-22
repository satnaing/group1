package com.napier.group1;

import java.io.IOException;
import java.sql.*;

public class App
{
    public static void main(String[] args) throws IOException {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect("localhost:33060");

//         Display Top Populated countries in the world
        a.getCountry();
//
//        // Display Top Populated countries in a continent
//        a.getCountryInContinent();
//
//        // Display Top Populated countries in a region
//        a.getCountryInRegion();
//
//        // Display Top Populated cities in the world
//        a.displayCitiesWorld();
//
//        // Display Top Populated cities in a continent
//        a.displayCitiesContinent();
//
//        // Display Top Populated cities in a continent
//        a.displayCitiesRegion();
//
//        // Display Top Populated cities in a continent
//        a.displayCitiesCountry();
//
//        // Display Top Populated cities in a continent
//        a.displayCitiesDistrict();
//
//        // All the capital cities in the world organised by largest population to smallest.
//        a.displayCapitalWorld();
//
//        // All the capital cities in a continent organised by largest population to smallest.
//        a.displayCapitalContinent();
//
//        // All the capital cities in a region organised by largest to smallest.
//        a.displayCapitalRegion();

//        Department dept = a.getDepartment("Sales");
//        ArrayList<Employee> employees = a.getSalariesByDepartment(dept);
//
//        // Print salary report
//        a.printSalaries(employees);

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
    public void connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
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
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
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

    public world getCountry()
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
                world wd = new world();
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

    public world getCountryInContinent()
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
            // Displaying Countries of Asia Continent
            System.out.println("Continent : Asia");
            System.out.println("-----------------");
            while (rsetStr.next()){
                world wd = new world();
                wd.Name = rsetStr.getString("Name");
                wd.Population = rsetStr.getInt("Population");
                System.out.println(
                        "Country:" + wd.Name + "\n" +
                                "Population: " + wd.Population + "\n");
            }
            System.out.println("-----------------"+ "\n");

            // Create Europe string for SQL statement
            String strContEurope =
                    "SELECT Name, Population "
                            + "FROM country WHERE continent = 'Europe' "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rsetStrEurope = stmt.executeQuery(strContEurope);
            // Displaying Countries of Europe Continent
            System.out.println("Continent : Europe");
            System.out.println("-----------------");
            while (rsetStrEurope.next()){
                world wd = new world();
                wd.Name = rsetStrEurope.getString("Name");
                wd.Population = rsetStrEurope.getInt("Population");
                System.out.println(
                        "Country:" + wd.Name + "\n" +
                                "Population: " + wd.Population + "\n");
            }
            System.out.println("-----------------"+ "\n");

            // Create North America string for SQL statement
            String strContNAmerica =
                    "SELECT Name, Population "
                            + "FROM country WHERE continent = 'North America' "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rsetStrNAmerica = stmt.executeQuery(strContNAmerica);
            // Displaying Countries of Europe Continent
            System.out.println("Continent : North America");
            System.out.println("-----------------");
            while (rsetStrNAmerica.next()){
                world wd = new world();
                wd.Name = rsetStrNAmerica.getString("Name");
                wd.Population = rsetStrNAmerica.getInt("Population");
                System.out.println(
                        "Country:" + wd.Name + "\n" +
                                "Population: " + wd.Population + "\n");
            }
            System.out.println("-----------------"+ "\n");

            // Create Africa string for SQL statement
            String strContAfrica =
                    "SELECT Name, Population "
                            + "FROM country WHERE continent = 'Africa' "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rsetStrAfrica = stmt.executeQuery(strContAfrica);
            // Displaying Countries of Africa Continent
            System.out.println("Continent : Africa");
            System.out.println("-----------------");
            while (rsetStrAfrica.next()){
                world wd = new world();
                wd.Name = rsetStrAfrica.getString("Name");
                wd.Population = rsetStrAfrica.getInt("Population");
                System.out.println(
                        "Country:" + wd.Name + "\n" +
                                "Population: " + wd.Population + "\n");
            }
            System.out.println("-----------------"+ "\n");

            // Create Oceania string for SQL statement
            String strContOceania =
                    "SELECT Name, Population "
                            + "FROM country WHERE continent = 'Oceania' "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rsetStrOceania = stmt.executeQuery(strContOceania);
            // Displaying Countries of Oceania Continent
            System.out.println("Continent : Oceania");
            System.out.println("-----------------");
            while (rsetStrOceania.next()){
                world wd = new world();
                wd.Name = rsetStrOceania.getString("Name");
                wd.Population = rsetStrOceania.getInt("Population");
                System.out.println(
                        "Country:" + wd.Name + "\n" +
                                "Population: " + wd.Population + "\n");
            }
            System.out.println("-----------------"+ "\n");

            // Create Antarctica string for SQL statement
            String strContAntarctica =
                    "SELECT Name, Population "
                            + "FROM country WHERE continent = 'Antarctica' "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rsetStrAntarctica = stmt.executeQuery(strContAntarctica);
            // Displaying Countries of Europe Continent
            System.out.println("Continent : Antarctica");
            System.out.println("-----------------");
            while (rsetStrAntarctica.next()){
                world wd = new world();
                wd.Name = rsetStrAntarctica.getString("Name");
                wd.Population = rsetStrAntarctica.getInt("Population");
                System.out.println(
                        "Country:" + wd.Name + "\n" +
                                "Population: " + wd.Population + "\n");
            }
            System.out.println("-----------------"+ "\n");

            // Create South America string for SQL statement
            String strContAmerica =
                    "SELECT Name, Population "
                            + "FROM country WHERE continent = 'South America' "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rsetStrAmerica = stmt.executeQuery(strContAmerica);
            // Displaying Countries of South America Continent
            System.out.println("Continent : South America");
            System.out.println("-----------------");
            while (rsetStrAmerica.next()){
                world wd = new world();
                wd.Name = rsetStrAmerica.getString("Name");
                wd.Population = rsetStrAmerica.getInt("Population");
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

    public world getCountryInRegion()
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
                world wd = new world();
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

    public world displayCitiesWorld()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create Asia string for SQL statement
            String strCont =
                    "SELECT city.Name, city.Population " +
                            "FROM city " +
                            "INNER JOIN country ON country.Code=city.CountryCode " +
                            "ORDER BY city.Population DESC";
//                    "SELECT Name, Population "
//                            + "FROM city "
//                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet rsetStr = stmt.executeQuery(strCont);
            // Check one is returned

            // Displaying Countries of Asia Continent
            System.out.println("Cities in the world according to Population");
            System.out.println("-----------------");
            while (rsetStr.next()){
                world wd = new world();
                wd.Name = rsetStr.getString("Name");
                wd.Population = rsetStr.getInt("Population");
                System.out.println(
                        "City:" + wd.Name + "\n" +
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

    public world displayCitiesContinent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create Asia string for SQL statement
            String strCont =
                    "SELECT city.Name, city.Population " +
                            "FROM city " +
                            "INNER JOIN country ON country.Code=city.CountryCode WHERE country.Continent='Asia' " +
                            "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rsetStr = stmt.executeQuery(strCont);
            // Check one is returned

            // Displaying Countries of Asia Continent
            System.out.println("Cities in Asia according to Population");
            System.out.println("-----------------");
            while (rsetStr.next()){
                world wd = new world();
                wd.Name = rsetStr.getString("city.Name");
                wd.Population = rsetStr.getInt("city.Population");
                System.out.println(
                        "City:" + wd.Name + "\n" +
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

    public world displayCitiesRegion()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create Cities in region(Southeast Asia) string for SQL statement
            String strCont =
                    "SELECT city.Name, city.Population " +
                            "FROM city " +
                            "INNER JOIN country ON country.Code=city.CountryCode WHERE country.Region='Southeast Asia' " +
                            "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rsetStr = stmt.executeQuery(strCont);
            // Check one is returned

            // Displaying Countries of Asia Continent
            System.out.println("Cities in Southeast Asia according to Population");
            System.out.println("-----------------");
            while (rsetStr.next()){
                world wd = new world();
                wd.Name = rsetStr.getString("city.Name");
                wd.Population = rsetStr.getInt("city.Population");
                System.out.println(
                        "City:" + wd.Name + "\n" +
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

    public world displayCitiesDistrict()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create Cities in region(Southeast Asia) string for SQL statement
            String strCont =
                    "SELECT city.Name, city.Population " +
                            "FROM city " +
                            "INNER JOIN country ON country.Code=city.CountryCode WHERE city.District='New York' " +
                            "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rsetStr = stmt.executeQuery(strCont);
            // Check one is returned

            // Displaying Countries of Asia Continent
            System.out.println("Cities in New York according to Population");
            System.out.println("-----------------");
            while (rsetStr.next()){
                world wd = new world();
                wd.Name = rsetStr.getString("city.Name");
                wd.Population = rsetStr.getInt("city.Population");
                System.out.println(
                        "City:" + wd.Name + "\n" +
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

    public world displayCitiesCountry()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create Cities in a Country(Myanmar) string for SQL statement
            String strCont =
                    "SELECT city.Name, city.Population " +
                            "FROM city " +
                            "INNER JOIN country ON country.Code=city.CountryCode WHERE country.Name='Myanmar' " +
                            "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rsetStr = stmt.executeQuery(strCont);
            // Check one is returned

            // Displaying Countries of Asia Continent
            System.out.println("Cities in Myanmar according to Population");
            System.out.println("-----------------");
            while (rsetStr.next()){
                world wd = new world();
                wd.Name = rsetStr.getString("city.Name");
                wd.Population = rsetStr.getInt("city.Population");
                System.out.println(
                        "City:" + wd.Name + "\n" +
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


    public world displayCapitalWorld()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population " +
                            "FROM city " +
                            "INNER JOIN country ON country.Capital=city.ID " +
                            "ORDER BY city.Population DESC";
//
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Check one is returned

            System.out.println("Top Populated Capitals");
            while (rset.next()){
                world wd = new world();
                wd.Name = rset.getString("city.Name");
                wd.Population = rset.getInt("city.Population");
                System.out.println(
                        "Capital:" + wd.Name + "\n" +
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


    public world displayCapitalContinent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population " +
                            "FROM city " +
                            "INNER JOIN country ON country.Capital=city.ID WHERE country.Continent='Asia' " +
                            "ORDER BY city.Population DESC";
//
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Check one is returned

            System.out.println("Top Populated Capitals in Asia");
            while (rset.next()){
                world wd = new world();
                wd.Name = rset.getString("city.Name");
                wd.Population = rset.getInt("city.Population");
                System.out.println(
                        "Capital:" + wd.Name + "\n" +
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




    public world displayCapitalRegion()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population " +
                            "FROM city " +
                            "INNER JOIN country ON country.Capital=city.ID WHERE country.Region='Southeast Asia' " +
                            "ORDER BY city.Population DESC";
//
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Check one is returned

            System.out.println("Top Populated Capitals in Southeast Asia");
            while (rset.next()){
                world wd = new world();
                wd.Name = rset.getString("city.Name");
                wd.Population = rset.getInt("city.Population");
                System.out.println(
                        "Capital:" + wd.Name + "\n" +
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
}