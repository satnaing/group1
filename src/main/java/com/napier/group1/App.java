package com.napier.group1;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class App
{
    public static void main(String[] args) throws IOException {
        // Create new Application
        App a = new App();

        // Connect to database
        if (args.length < 1)
        {
            a.connect("localhost:3306");
        }
        else
        {
            a.connect(args[0]);
        }


        // Display Top Populated countries in the world
        Country c1=a.getCountry();
        //System.out.println(c1.getName()+"\t"+c1.getPopulation());
        a.displayCountry(c1);

        //test integration city
        City trycty =a.getCity(2710);
        System.out.println(trycty);

//        Country c2 = a.getCountryInContinent();
        ArrayList<Country> c = a.getCountryInContinent();
        a.displayCountryContinent(c);

        ArrayList<Country> countryInCon = a.getCountryInRegion();
        a.displayCountryInRegion(countryInCon);
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


    public City getCity(int id) {
        City city=null;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = "SELECT ID, Name, District, Population "
                    +"FROM city "
                    +"WHERE ID = " + id + " ";
            //Execute SQL statement
            ResultSet rset=stmt.executeQuery(strSelect);
            if (rset == null)
            {
                System.out.println("Not Found");
            }
            else
            {
                //Return new city if valid.
                while (rset.next()){
                    city=new City();
                    city.setID(rset.getInt(1));
                    city.setName(rset.getString(2));
                    city.setDistrict(rset.getString(3));
                    city.setPopulation(rset.getInt(4));
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get one city!");
        }
        return city;
    }



    public Country getCountry()
    {
        try
        {  Country ctry=null;
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
                ctry = new Country();
                ctry.setName(rset.getString("Name"));
                ctry.setPopulation(rset.getInt("Population"));
                System.out.println(
                    "Country:" + ctry.getName() + "\n" +
                        "Population: " + ctry.getPopulation() + "\n");
            }
            return ctry;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }
    public void displayCountry(Country c)
    {
        if (c == null){
            System.out.println("No Country");
            return;
        }
        else {
            System.out.println(c.getName());
            System.out.println(c.getPopulation());
        }

    }

    public ArrayList<Country> getCountryInContinent()
    {
        ArrayList<Country> countries=null;
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

            if (rsetStr==null){System.out.println("No data got");}
            else {
                countries=new ArrayList<>();
                while (rsetStr.next()) {
                    Country wd= new Country();

                    wd.setName(rsetStr.getString("Name"));
                    wd.setPopulation(rsetStr.getInt("Population"));
//                System.out.println(
//                        "Country:" + wd.Name + "\n" +
//                                "Population: " + wd.Population + "\n");
                    countries.add(wd);
                }
            }
            System.out.println("-----------------"+ "\n");

            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country Data from database" + e);
            return null;
        }
    }

    public void displayCountryContinent(ArrayList<Country> c)
    {
        if (c==null) {
            System.out.println("No Countries found!!!");
        }
        else{
            for (Country ct:c) {
                System.out.println(ct.getName() + ct.getPopulation());
            }
        }
    }


    public ArrayList<Country> getCountryInRegion()
    {
        ArrayList<Country> countries=null;
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create Asia string for SQL statement
            String strCont =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country WHERE Region = 'Southeast Asia' "
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet rsetStr = stmt.executeQuery(strCont);
            // Check one is returned

            // Displaying Countries of Asia Continent
            System.out.println("Region : Southeast Asia");
            System.out.println("-----------------");

            if (rsetStr == null){
                System.out.println("No data found!");
            }
            else{
                countries = new ArrayList<>();
                while (rsetStr.next()){
                    Country wd = new Country();
                    wd.setName(rsetStr.getString("Name"));
                    wd.setPopulation(rsetStr.getInt("Population"));
//                    System.out.println(
//                            "Country:" + wd.Name + "\n" +
//                                    "Population: " + wd.Population + "\n");
                    countries.add(wd);
                }
            }
            System.out.println("-----------------"+ "\n");
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details : " + e);
            return null;
        }
    }


    public void displayCountryInRegion(ArrayList<Country> c)
    {
        if (c==null) {
            System.out.println("No Countries found (or) null value detected");
        }
        else{
            for (Country ct:c) {
                System.out.println(ct.getName() + ct.getPopulation());
            }
        }
    }


    public World displayCitiesWorld()
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
                World wd = new World();
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

    public World displayCitiesContinent()
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
                World wd = new World();
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

    public World displayCitiesRegion()
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
                World wd = new World();
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

    public World displayCitiesDistrict()
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
                World wd = new World();
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

    public World displayCitiesCountry()
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
                World wd = new World();
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


    public World displayCapitalWorld()
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
                World wd = new World();
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


    public World displayCapitalContinent()
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
                World wd = new World();
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




    public World displayCapitalRegion()
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
                World wd = new World();
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