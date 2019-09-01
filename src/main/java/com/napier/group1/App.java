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
            a.connect("localhost:33060");
        }
        else
        {
            a.connect(args[0]);
        }

        /*Country Report*/
        //Display Top Populated countries in the world
        Country c1=a.getCountry();
        System.out.println(c1.getName()+"\t"+c1.getPopulation());
        a.displayCountry(c1);

        ArrayList<Country> c = a.getCountryInContinent("North America");
        a.displayCountryContinent(c);

        ArrayList<Country> countryInReg = a.getCountryInRegion("Southeast Asia");
        a.displayCountryInRegion(countryInReg);

        // test integration city
        a.getSpecificCity(2710);
        //System.out.println(trycty);

        /*City Report*/
        a.getCity();
        a.getCitiesContinent("Asia");
        a.getCitiesRegion("Southeast Asia");
        a.getCitiesDistrict("Mandalay");
        a.getCitiesCountry("Myanmar");


        /*Capital City Report*/
        a.getCapitalWorld();
        a.getCapitalContinent("Asia");
        a.getCapitalRegion("Southeast Asia");

        /*Population Report*/
        a.totalPopuRegion("Oceania");
        System.out.println(a.totalPopuRegion("Southeast Asia"));
        System.out.println(a.populationLivingInCitiesRegion("Southeast Asia"));


        int total = a.totalPopuRegion("Southeast Asia");
        int liveCities = a.populationLivingInCitiesRegion("Southeast Asia");
        a.populationRgn(total, liveCities, "Southeast Asia");

        String continent = "Asia";
        double totalPopuCon = a.totalPopuContinent(continent);
        double liveCitiesCon = a.populationLivingInCitiesContinent(continent);
        a.populationContinent(totalPopuCon, liveCitiesCon, continent);

        double totalPopuCountry = a.totalPopuCountry("Myanmar");
        double liveCitiesCountry = a.populationLivingInCitiesCountry("Myanmar");
        a.populationCountry(totalPopuCountry, liveCitiesCountry, "Myanmar");

        // Disconnect from database
        a.disconnect();
    }




    /**
     * All the countries in the world
     * organised by largest population to smallest.
     */
    public Country getCountry()
    {
        try
        {  Country ctry=null;
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Check one is returned

            System.out.println("All the countries in the world organised by largest population to smallest.");
            while (rset.next()){
                ctry = new Country();
                ctry.setCode(rset.getString("Code"));
                ctry.setName(rset.getString("Name"));
                ctry.setContinent(rset.getString("Continent"));
                ctry.setRegion(rset.getString("Region"));
                ctry.setPopulation(rset.getInt("Population"));
                ctry.setCapital(rset.getString("Capital"));
                System.out.println(
                        "Code: " + ctry.getCode() + "\n" +
                        "Country:" + ctry.getName() + "\n" +
                        "Continent: " + ctry.getContinent() + "\n" +
                        "Region: " + ctry.getRegion() + "\n" +
                        "Population: " + ctry.getPopulation() + "\n" +
                        "Capital: " + ctry.getCapital());
                System.out.println("_____________________");
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
            System.out.println(c.getCode());
            System.out.println(c.getName());
            System.out.println(c.getContinent());
            System.out.println(c.getRegion());
            System.out.println(c.getPopulation());
            System.out.println(c.getCapital()+"\n");
        }

    }


    /**
     * All the countries in a continent
     * organised by largest population to smallest.
     */
    public ArrayList<Country> getCountryInContinent(String c)
    {
        ArrayList<Country> countries=null;
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create Asia string for SQL statement
            String strCont =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country WHERE continent = " + "\"" + c + "\"" +
            " ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rsetStr = stmt.executeQuery(strCont);

            if (rsetStr==null){System.out.println("No data got");}
            else {
                countries=new ArrayList<>();
                while (rsetStr.next()) {
                    Country wd= new Country();

                    wd.setCode(rsetStr.getString("Code"));
                    wd.setName(rsetStr.getString("Name"));
                    wd.setContinent(rsetStr.getString("Continent"));
                    wd.setRegion(rsetStr.getString("Region"));
                    wd.setPopulation(rsetStr.getInt("Population"));
                    wd.setCapital(rsetStr.getString("Capital"));
                    countries.add(wd);
                }
            }
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
            // Displaying Countries of Specific Continent
            String continent = "";
            for (Country ct:c){
                continent = ct.getContinent();
            }
            System.out.println("Continent : " + continent);
            System.out.println("-----------------------");
            for (Country ct:c) {
                System.out.println(
                        "Code: " + ct.getCode() + "\n" +
                        "Name: " + ct.getName() + "\n" +
                        "Continent: " + ct.getContinent() + "\n" +
                        "Region: " + ct.getRegion() + "\n" +
                        "Population: " + ct.getPopulation() + "\n" +
                        "Capital: " + ct.getCapital());
                System.out.println("-----------------------");
            }
            System.out.println("_______________________");
        }
    }


    /**
     * All the countries in a region
     * organised by largest population to smallest.
     */
    public ArrayList<Country> getCountryInRegion(String reg)
    {
        ArrayList<Country> countries=null;
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create Asia string for SQL statement
            String strCont =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country WHERE Region = " + "\"" + reg + "\""
                            + " ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet rsetStr = stmt.executeQuery(strCont);
            // Check one is returned

            if (rsetStr == null){
                System.out.println("No data found!");
            }
            else{
                countries = new ArrayList<>();
                while (rsetStr.next()){
                    Country wd = new Country();
                    wd.setCode(rsetStr.getString("Code"));
                    wd.setName(rsetStr.getString("Name"));
                    wd.setContinent(rsetStr.getString("Continent"));
                    wd.setRegion(rsetStr.getString("Region"));
                    wd.setPopulation(rsetStr.getInt("Population"));
                    wd.setCapital(rsetStr.getString("Capital"));
                    countries.add(wd);
                }
            }
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
            // Displaying Countries of Specific Region
            String region = "";
            for (Country ct:c){
                region = ct.getRegion();
            }
            System.out.println("Region : " + region);
            System.out.println("-----------------------");
            for (Country ct:c) {
                System.out.println(
                        "Code: " + ct.getCode() + "\n" +
                                "Name: " + ct.getName() + "\n" +
                                "Continent: " + ct.getContinent() + "\n" +
                                "Region: " + ct.getRegion() + "\n" +
                                "Population: " + ct.getPopulation() + "\n" +
                                "Capital: " + ct.getCapital());
                System.out.println("-----------------------");
            }
            System.out.println("_______________________");
        }
    }


    /**
     * Get Specific City
     */
    public City getSpecificCity(int id) {
        City city=null;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = "SELECT city.Name, city.District, city.Population, country.Name "
                    +"FROM city "
                    +"INNER JOIN country ON country.Code=city.CountryCode "
                    +"WHERE ID = " + id + " ";
            //Execute SQL statement
            ResultSet rset=stmt.executeQuery(strSelect);
            if (rset == null)
            {
                System.out.println("Not Found");
            }
            else
            {
                System.out.println("Specific city for id : " + id);
                //Return new city if valid.
                while (rset.next()){
                    city=new City();
                    city.setName(rset.getString("city.Name"));
                    city.setDistrict(rset.getString("city.District"));
                    city.setPopulation(rset.getInt("city.Population"));
                    city.setCountryName(rset.getString("country.Name"));
                    System.out.println(
                            "Name: " + city.getName() + "\n" +
                                    "Country:" + city.getCountryName() + "\n" +
                                    "District: " + city.getDistrict() + "\n" +
                                    "Population: " + city.getPopulation() + "\n");
                    System.out.println("_____________________"+"\n");
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


    /**
     * All the cities in the world
     * organised by largest population to smallest.
     */
    public City getCity() {
        City city=null;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = "SELECT city.Name, city.District, city.Population, country.Name "
                    +"FROM city "
                    +"INNER JOIN country ON country.Code=city.CountryCode "
                    + "ORDER BY city.Population DESC";
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
                    city.setName(rset.getString("city.Name"));
                    city.setDistrict(rset.getString("city.District"));
                    city.setPopulation(rset.getInt("city.Population"));
                    city.setCountryName(rset.getString("country.Name"));
                    System.out.println(
                            "Name: " + city.getName() + "\n" +
                                    "Country: " + city.getCountryName() + "\n" +
                                    "District: " + city.getDistrict() + "\n" +
                                    "Population: " + city.getPopulation() + "\n");
                    System.out.println("-----------------------");
                }
                System.out.println("_______________________");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get one city!");
        }
        return city;
    }


    /**
     * All the cities in a continent
     * organised by largest population to smallest.
     */
    public City getCitiesContinent(String continent) {
        City city=null;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = "SELECT city.Name, city.District, city.Population, country.Name "
                    +"FROM city "
                    +"INNER JOIN country ON country.Code=city.CountryCode "
                    +"WHERE country.Continent = " + "\"" + continent + "\""
                    +" ORDER BY city.Population DESC";
            //Execute SQL statement
            ResultSet rset=stmt.executeQuery(strSelect);
            if (rset == null)
            {
                System.out.println("Not Found");
            }
            else
            {
                System.out.println("Cities in Continent : " + continent);
                System.out.println("-----------------------");
                //Return new city if valid.
                while (rset.next()){
                    city=new City();
                    city.setName(rset.getString("city.Name"));
                    city.setDistrict(rset.getString("city.District"));
                    city.setPopulation(rset.getInt("city.Population"));
                    city.setCountryName(rset.getString("country.Name"));
                    System.out.println(
                            "Name: " + city.getName() + "\n" +
                                    "Country: " + city.getCountryName() + "\n" +
                                    "District: " + city.getDistrict() + "\n" +
                                    "Population: " + city.getPopulation() + "\n");
                    System.out.println("-----------------------");
                }
                System.out.println("_______________________");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get one city!");
        }
        return city;
    }


    /**
     * All the cities in a region
     * organised by largest population to smallest.
     */
    public City getCitiesRegion(String region) {
        City city=null;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = "SELECT city.Name, city.District, city.Population, country.Name "
                    +"FROM city "
                    +"INNER JOIN country ON country.Code=city.CountryCode "
                    +"WHERE country.Region = " + "\"" + region + "\""
                    +" ORDER BY city.Population DESC";
            //Execute SQL statement
            ResultSet rset=stmt.executeQuery(strSelect);
            if (rset == null)
            {
                System.out.println("Not Found");
            }
            else
            {
                System.out.println("Cities in Region : " + region);
                System.out.println("-----------------------");
                //Return new city if valid.
                while (rset.next()){
                    city=new City();
                    city.setName(rset.getString("city.Name"));
                    city.setDistrict(rset.getString("city.District"));
                    city.setPopulation(rset.getInt("city.Population"));
                    city.setCountryName(rset.getString("country.Name"));
                    System.out.println(
                            "Name: " + city.getName() + "\n" +
                                    "Country: " + city.getCountryName() + "\n" +
                                    "District: " + city.getDistrict() + "\n" +
                                    "Population: " + city.getPopulation() + "\n");
                    System.out.println("-----------------------");
                }
                System.out.println("_______________________");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get one city!");
        }
        return city;
    }


    /**
     * All the cities in a district
     * organised by largest population to smallest.
     */
    public City getCitiesDistrict(String district) {
        City city=null;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = "SELECT city.Name, city.District, city.Population, country.Name "
                    +"FROM city "
                    +"INNER JOIN country ON country.Code=city.CountryCode "
                    +"WHERE city.District = " + "\"" + district + "\""
                    +" ORDER BY city.Population DESC";
            //Execute SQL statement
            ResultSet rset=stmt.executeQuery(strSelect);
            if (rset == null)
            {
                System.out.println("Not Found");
            }
            else
            {
                System.out.println("Cities in District : " + district);
                System.out.println("-----------------------");
                //Return new city if valid.
                while (rset.next()){
                    city=new City();
                    city.setName(rset.getString("city.Name"));
                    city.setDistrict(rset.getString("city.District"));
                    city.setPopulation(rset.getInt("city.Population"));
                    city.setCountryName(rset.getString("country.Name"));
                    System.out.println(
                            "Name: " + city.getName() + "\n" +
                                    "Country: " + city.getCountryName() + "\n" +
                                    "District: " + city.getDistrict() + "\n" +
                                    "Population: " + city.getPopulation() + "\n");
                    System.out.println("-----------------------");
                }
                System.out.println("_______________________");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get one city!");
        }
        return city;
    }


    /**
     * All the cities in a district
     * organised by largest population to smallest.
     */
    public City getCitiesCountry(String country) {
        City city=null;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = "SELECT city.Name, city.District, city.Population, country.Name "
                    +"FROM city "
                    +"INNER JOIN country ON country.Code=city.CountryCode "
                    +"WHERE country.Name = " + "\"" + country + "\""
                    +" ORDER BY city.Population DESC";
            //Execute SQL statement
            ResultSet rset=stmt.executeQuery(strSelect);
            if (rset == null)
            {
                System.out.println("Not Found");
            }
            else
            {
                System.out.println("Cities in Country : " + country);
                System.out.println("-----------------------");
                //Return new city if valid.
                while (rset.next()){
                    city=new City();
                    city.setName(rset.getString("city.Name"));
                    city.setDistrict(rset.getString("city.District"));
                    city.setPopulation(rset.getInt("city.Population"));
                    city.setCountryName(rset.getString("country.Name"));
                    System.out.println(
                            "Name: " + city.getName() + "\n" +
                                    "Country: " + city.getCountryName() + "\n" +
                                    "District: " + city.getDistrict() + "\n" +
                                    "Population: " + city.getPopulation() + "\n");
                    System.out.println("-----------------------");
                }
                System.out.println("_______________________");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get one city!");
        }
        return city;
    }


    /**
     * All the capital cities in the world
     * organised by largest population to smallest.
     */
    public City getCapitalWorld() {
        City city=null;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = "SELECT city.Name, city.Population, country.Name "
                    +"FROM city "
                    +"INNER JOIN country ON country.Capital=city.ID "
                    +" ORDER BY city.Population DESC";
            //Execute SQL statement
            ResultSet rset=stmt.executeQuery(strSelect);
            if (rset == null)
            {
                System.out.println("Not Found");
            }
            else
            {
                System.out.println("Capital Cities in the World Ordered by Population.");
                System.out.println("-----------------------");
                //Return new city if valid.
                while (rset.next()){
                    city=new City();
                    city.setName(rset.getString("city.Name"));
                    city.setPopulation(rset.getInt("city.Population"));
                    city.setCountryName(rset.getString("country.Name"));
                    System.out.println(
                            "Name: " + city.getName() + "\n" +
                                    "Country: " + city.getCountryName() + "\n" +
                                    "Population: " + city.getPopulation() + "\n");
                    System.out.println("-----------------------");
                }
                System.out.println("_______________________");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get one city!");
        }
        return city;
    }


    /**
     * All the capital cities in the world
     * organised by largest population to smallest.
     */
    public City getCapitalContinent(String continent) {
        City city=null;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = "SELECT city.Name, city.Population, country.Name "
                    +"FROM city "
                    +"INNER JOIN country ON country.Capital=city.ID "
                    +"WHERE country.Continent = " + "\"" + continent + "\""
                    +" ORDER BY city.Population DESC";
            //Execute SQL statement
            ResultSet rset=stmt.executeQuery(strSelect);
            if (rset == null)
            {
                System.out.println("Not Found");
            }
            else
            {
                System.out.println("Capital Cities in " + continent + " continent Ordered by Population.");
                System.out.println("-----------------------");
                //Return new city if valid.
                while (rset.next()){
                    city=new City();
                    city.setName(rset.getString("city.Name"));
                    city.setPopulation(rset.getInt("city.Population"));
                    city.setCountryName(rset.getString("country.Name"));
                    System.out.println(
                            "Name: " + city.getName() + "\n" +
                                    "Country: " + city.getCountryName() + "\n" +
                                    "Population: " + city.getPopulation() + "\n");
                    System.out.println("-----------------------");
                }
                System.out.println("_______________________");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get one city!");
        }
        return city;
    }


    /**
     * All the capital cities in a region
     * organised by largest to smallest.
     */
    public City getCapitalRegion(String region) {
        City city=null;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = "SELECT city.Name, city.Population, country.Name "
                    +"FROM city "
                    +"INNER JOIN country ON country.Capital=city.ID "
                    +"WHERE country.Region = " + "\"" + region + "\""
                    +" ORDER BY city.Population DESC";
            //Execute SQL statement
            ResultSet rset=stmt.executeQuery(strSelect);
            if (rset == null)
            {
                System.out.println("Not Found");
            }
            else
            {
                System.out.println("Capital Cities in " + region + " region Ordered by Population.");
                System.out.println("-----------------------");
                //Return new city if valid.
                while (rset.next()){
                    city=new City();
                    city.setName(rset.getString("city.Name"));
                    city.setPopulation(rset.getInt("city.Population"));
                    city.setCountryName(rset.getString("country.Name"));
                    System.out.println(
                            "Name: " + city.getName() + "\n" +
                                    "Country: " + city.getCountryName() + "\n" +
                                    "Population: " + city.getPopulation() + "\n");
                    System.out.println("-----------------------");
                }
                System.out.println("_______________________");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get one city!");
        }
        return city;
    }


    /**
     * Total population in a specific region
     */
    public int totalPopuRegion(String region) {
        Country cont=null;
        int totalPopulation = 0;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Name, Population FROM country WHERE region=" + "\"" + region + "\"";
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
                    cont=new Country();
                    cont.setName(rset.getString("Name"));
                    cont.setPopulation(rset.getInt("Population"));
                    //System.out.println("Name : " + cont.getName() + "\n" + "Population : " + cont.getPopulation());
                    totalPopulation += cont.getPopulation();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get data!");
        }
        return totalPopulation;
    }


    /**
     * Total population in a specific region
     */
    public int populationLivingInCitiesRegion(String region) {
        Country cont=null;
        int totalPopulation = 0;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name, city.Population, country.Region " +
                            "FROM city " +
                            "INNER JOIN country ON country.Code=city.CountryCode "+
                            "WHERE country.Region=" + "\"" + region + "\"";
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
                    cont=new Country();
                    cont.setName(rset.getString("city.Name"));
                    cont.setPopulation(rset.getInt("city.Population"));
                    cont.setRegion(rset.getString("country.Region"));
//                    System.out.println(
//                            "Name : " + cont.getName() + "\n" +
//                            "Population : " + cont.getPopulation() + "\n" +
//                            "Region : " + cont.getRegion());
                    totalPopulation += cont.getPopulation();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get data!");
        }
        return totalPopulation;
    }


    /**
     * The population of people,
     * people living in cities, and
     * people not living in cities in each continent.
     */
    public void populationRgn(int total, int liveCities, String region)
    {
        int notLiveCities = 0;
        double perLiveCities = 0;
        double perNotLiveCities = 0;
        notLiveCities = total - liveCities;
        //per = (liveCities*100)/total;
        double dtotal = total;
        double dliveCities = liveCities;
        perLiveCities = dliveCities/dtotal*100;
        perNotLiveCities = 100 - perLiveCities;
        System.out.println("Population Report in "+ region + " Region");
        System.out.println("-----------------------------------------");
        System.out.println(
                "Region : " + region + "\n" +
                        "Total Population : " + total + "\n" +
                        "People living in Cities : " + liveCities + String.format("%s%.2f%s"," (", perLiveCities,"%) ") + "\n" +
                        "People not living in Cities : " + notLiveCities + String.format("%s%.2f%s"," (", perNotLiveCities,"%)") );
        System.out.println("-----------------------------------------");
    }


    /**
     * Total population in a specific continent
     */
    public double totalPopuContinent(String continent) {
        Country cont=null;
        double totalPopulation = 0;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Name, Population FROM country WHERE continent=" + "\"" + continent + "\"";
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
                    cont=new Country();
                    cont.setName(rset.getString("Name"));
                    cont.setPopulation(rset.getInt("Population"));
                    //System.out.println("Name : " + cont.getName() + "\n" + "Population : " + cont.getPopulation());
                    totalPopulation += cont.getPopulation();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get data!");
        }
        return totalPopulation;
    }


    /**
     * Total population living in cities in a specific continent
     */
    public double populationLivingInCitiesContinent(String continent) {
        Country cont=null;
        double totalPopulation = 0;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name, city.Population, country.Continent " +
                            "FROM city " +
                            "INNER JOIN country ON country.Code=city.CountryCode "+
                            "WHERE country.Continent=" + "\"" + continent + "\"";
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
                    cont=new Country();
                    cont.setName(rset.getString("city.Name"));
                    cont.setPopulation(rset.getInt("city.Population"));
                    cont.setContinent(rset.getString("country.Continent"));
//                    System.out.println(
//                            "Name : " + cont.getName() + "\n" +
//                            "Population : " + cont.getPopulation() + "\n" +
//                            "Continent : " + cont.getContinent());
                    totalPopulation += cont.getPopulation();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get data!");
        }
        return totalPopulation;
    }


    /**
     * The population of people,
     * people living in cities, and
     * people not living in cities in each continent.
     */
    public void populationContinent(double total, double liveCities, String continent)
    {
        int notLiveCities = 0;
        double perLiveCities = 0;
        double perNotLiveCities = 0;
        notLiveCities = (int) (total - liveCities);
        perLiveCities = liveCities/total*100;
        perNotLiveCities = 100 - perLiveCities;
        System.out.println("Population Report in "+ continent + " Continent");
        System.out.println("-----------------------------------------");
        System.out.println(
                "Continent : " + continent + "\n" +
                        "Total Population : " + total + "\n" +
                        "People living in Cities : " + liveCities + String.format("%s%.2f%s"," (", perLiveCities,"%) ") + "\n" +
                        "People not living in Cities : " + notLiveCities + String.format("%s%.2f%s"," (", perNotLiveCities,"%)") );
        System.out.println("-----------------------------------------");
    }


    /**
     * Total population in a specific country
     */
    public double totalPopuCountry(String country) {
        Country cont=null;
        double totalPopulation = 0;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Name, Population FROM country WHERE Name=" + "\"" + country + "\"";
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
                    cont=new Country();
                    cont.setName(rset.getString("Name"));
                    cont.setPopulation(rset.getInt("Population"));
                    //System.out.println("Name : " + cont.getName() + "\n" + "Population : " + cont.getPopulation());
                    totalPopulation += cont.getPopulation();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get data!");
        }
        return totalPopulation;
    }


    /**
     * Total population living in cities in a specific continent
     */
    public double populationLivingInCitiesCountry(String country) {
        Country cont=null;
        double totalPopulation = 0;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name, city.Population, country.Continent " +
                            "FROM city " +
                            "INNER JOIN country ON country.Code=city.CountryCode "+
                            "WHERE country.Name=" + "\"" + country + "\"";
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
                    cont=new Country();
                    cont.setName(rset.getString("city.Name"));
                    cont.setPopulation(rset.getInt("city.Population"));
                    cont.setContinent(rset.getString("country.Continent"));
//                    System.out.println(
//                            "Name : " + cont.getName() + "\n" +
//                            "Population : " + cont.getPopulation() + "\n" +
//                            "Continent : " + cont.getContinent());
                    totalPopulation += cont.getPopulation();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get data!");
        }
        return totalPopulation;
    }


    /**
     * The population of people,
     * people living in cities, and
     * people not living in cities in each continent.
     */
    public void populationCountry(double total, double liveCities, String continent)
    {
        int notLiveCities = 0;
        double perLiveCities = 0;
        double perNotLiveCities = 0;
        notLiveCities = (int) (total - liveCities);
        perLiveCities = liveCities/total*100;
        perNotLiveCities = 100 - perLiveCities;
        System.out.println("Population Report in "+ continent);
        System.out.println("-----------------------------------------");
        System.out.println(
                "Continent : " + continent + "\n" +
                        "Total Population : " + total + "\n" +
                        "People living in Cities : " + liveCities + String.format("%s%.2f%s"," (", perLiveCities,"%) ") + "\n" +
                        "People not living in Cities : " + notLiveCities + String.format("%s%.2f%s"," (", perNotLiveCities,"%)") );
        System.out.println("_________________________________________");
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
}