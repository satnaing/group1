package com.napier.group1;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main(String[] args){
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

        // Input Display Method
        a.mainDisplay();

        // Disconnect from database
        a.disconnect();
    }

    public void mainDisplay()
    {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Welcome to Report System");
        System.out.println("########################");

        boolean again = false;
        do {
            System.out.println("Choose any of the following report type:");
            System.out.println(
                    "(1) Country Report. " + "\n" +
                    "(2) City Report. " + "\n" +
                    "(3) Capital City Report. " + "\n" +
                    "(4) Population Report." + "\n" +
                    "(5) Language Report."
            );
            System.out.print("Enter an option : ");
            int rptOption = myObj.nextInt();  // Read user input
            System.out.println("_________________________");

            // Country Report
            switch (rptOption) {
                case 1:
                    System.out.println("Country Report");
                    System.out.println("-----------------------");
                    System.out.println(
                            "(1) All the countries in the world organised by largest population to smallest." + "\n" +
                                    "(2) All the countries in a continent organised by largest population to smallest." + "\n" +
                                    "(3) All the countries in a region organised by largest population to smallest." + "\n" +
                                    "(4) The top N populated countries in the world." + "\n" +
                                    "(5) The top N populated countries in a continent." + "\n" +
                                    "(6) The top N populated countries in a region."
                    );
                    System.out.print("Enter an option : ");
                    int inputCountryRpt = myObj.nextInt();  // Read user input


                    switch (inputCountryRpt) {
                        case 1:
                            getCountry(99999);
                            again = askQuestion();
                            break;
                        case 2:
                            displayCountryContinent(getCountryInContinent(askContinent(), 99999));
                            again = askQuestion();
                            break;
                        case 3:
                            displayCountryInRegion(getCountryInRegion(askRegion(), 99999));
                            again = askQuestion();
                            break;
                        case 4:
                            getCountry(askTopNumber("Country"));
                            again = askQuestion();
                            break;
                        case 5:
                            displayCountryContinent(getCountryInContinent(askContinent(), askTopNumber("Country")));
                            again = askQuestion();
                            break;
                        case 6:
                            displayCountryInRegion(getCountryInRegion(askRegion(), askTopNumber("Country")));
                            again = askQuestion();
                            break;
                        default:
                            again = true;
                            break;
                    }
                    break;

                // City Report
                case 2:
                    System.out.println("City Report");
                    System.out.println("-----------------------");
                    System.out.println(
                            "(1) All the cities in the world organised by largest population to smallest. " + "\n" +
                                    "(2) All the cities in a continent organised by largest population to smallest. " + "\n" +
                                    "(3) All the cities in a region organised by largest population to smallest. " + "\n" +
                                    "(4) All the cities in a country organised by largest population to smallest. " + "\n" +
                                    "(5) All the cities in a district organised by largest population to smallest." + "\n" +
                                    "(6) The top N populated cities in the world." + "\n" +
                                    "(7) The top N populated cities in a continent." + "\n" +
                                    "(8) The top N populated cities in a region." + "\n" +
                                    "(9) The top N populated cities in a country." + "\n" +
                                    "(10) The top N populated cities in a district."
                    );
                    System.out.print("Enter an option : ");
                    int inputCityRpt = myObj.nextInt();  // Read user input


                    switch (inputCityRpt) {
                        case 1:
                            getCity(99999);
                            again = askQuestion();
                            break;
                        case 2:
                            getCitiesContinent(askContinent(), 99999);
                            again = askQuestion();
                            break;
                        case 3:
                            getCitiesRegion(askRegion(), 99999);
                            again = askQuestion();
                            break;
                        case 4:
                            getCitiesCountry(askCountry(), 99999);
                            again = askQuestion();
                            break;
                        case 5:
                            getCitiesDistrict(99999);
                            again = askQuestion();
                            break;
                        case 6:
                            getCity(askTopNumber("City"));
                            again = askQuestion();
                            break;
                        case 7:
                            getCitiesContinent(askContinent(), askTopNumber("City"));
                            again = askQuestion();
                            break;
                        case 8:
                            getCitiesRegion(askRegion(), askTopNumber("City"));
                            again = askQuestion();
                            break;
                        case 9:
                            getCitiesCountry(askCountry(), askTopNumber("City"));
                            again = askQuestion();
                            break;
                        case 10:

                            getCitiesDistrict(askTopNumber("City"));
                            again = askQuestion();
                            break;
                        default:
                            again = true;
                            break;
                    }
                    break;

                // Capital City Report
                case 3:
                    System.out.println("Capital City Report");
                    System.out.println("-----------------------");
                    System.out.println(
                            "(1) All the capital cities in the world organised by largest population to smallest. " + "\n" +
                            "(2) All the capital cities in a continent organised by largest population to smallest. " + "\n" +
                            "(3) All the capital cities in a region organised by largest to smallest." + "\n" +
                            "(4) The top N populated capital cities in the world." + "\n" +
                            "(5) The top N populated capital cities in a continent." + "\n" +
                            "(6) The top N populated capital cities in a region."
                    );
                    System.out.print("Enter an option : ");
                    int inputCapCityRpt = myObj.nextInt();  // Read user input


                    switch (inputCapCityRpt) {
                        case 1:
                            getCapitalWorld(99999);
                            again = askQuestion();
                            break;
                        case 2:
                            getCapitalContinent(askContinent(), 99999);
                            again = askQuestion();
                            break;
                        case 3:
                            getCapitalRegion(askRegion(), 99999);
                            again = askQuestion();
                            break;
                        case 4:
                            getCapitalWorld(askTopNumber("Capital City"));
                            again = askQuestion();
                            break;
                        case 5:
                            getCapitalContinent(askContinent(), askTopNumber("Capital City"));
                            again = askQuestion();
                            break;
                        case 6:
                            getCapitalRegion(askRegion(), askTopNumber("Capital City"));
                            again = askQuestion();
                            break;
                        default:
                            again = true;
                            break;
                    }
                    break;

                // Population Report
                case 4:
                    System.out.println("Population Report");
                    System.out.println("-----------------------");
                    System.out.println(
                        "(1) The population of people, people living in cities, and people not living in cities in each continent." + "\n" +
                        "(2) The population of people, people living in cities, and people not living in cities in each region." + "\n" +
                        "(3) The population of people, people living in cities, and people not living in cities in each country." + "\n" +
                        "(4) The population of the world." + "\n" +
                        "(5) The population of a district." + "\n" +
                        "(6) The population of a city."
                    );
                    System.out.print("Enter an option : ");
                    int inputPopRpt = myObj.nextInt();  // Read user input


                    switch (inputPopRpt) {
                        case 1:
                            String continent = askContinent();
                            double totalPopuCon = totalPopuContinent(continent);
                            double liveCitiesCon = populationLivingInCitiesContinent(continent);
                            populationContinent(totalPopuCon, liveCitiesCon, continent);
                            again = askQuestion();
                            break;
                        case 2:
                            String region = askRegion();
                            int total = totalPopuRegion(region);
                            int liveCities = populationLivingInCitiesRegion(region);
                            populationRgn(total, liveCities, region);
                            again = askQuestion();
                            break;
                        case 3:
                            String country = askCountry();
                            double totalPopuCountry = totalPopuCountry(country);
                            double liveCitiesCountry = populationLivingInCitiesCountry(country);
                            populationCountry(totalPopuCountry, liveCitiesCountry, country);
                            again = askQuestion();
                            break;
                        case 4:
                            totalWorldPop();
                            again = askQuestion();
                            break;
                        case 5:
                            String district = askDistrict();
                            totalPopuDistrict(district);
                            again = askQuestion();
                            break;
                        case 6:
                            String city = askCity();
                            totalPopuCity(city);
                            again = askQuestion();
                            break;
                        default:
                            again = true;
                            break;
                    }
                    break;
                case 5:
                    countryLanguage();
                    again = askQuestion();
                    break;
                default:
                    System.out.println("Wrong Choice!");  // Output user input

                    break;
            }
        }
        while (again);

    }


    public float totalWorldPop()
    {
        try
        {
            Country ctry;
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT Population FROM country ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Check one is returned

            float x = 0;
            while (rset.next()){
                ctry = new Country();
                ctry.setPopulation(rset.getInt("Population"));
                x += ctry.getPopulation();
            }
            System.out.println("Total Population : " + x);
            return x;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return 0;
        }
    }

    public CountryLanguage countryLanguage() {
        try
        {
            CountryLanguage ctl = null;
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT countrylanguage.Language, countrylanguage.Percentage, country.Population "
                    +"FROM countrylanguage "
                    +"INNER JOIN country ON country.Code = countrylanguage.CountryCode";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Check one is returned

            System.out.println("Language Report");
            System.out.println("------------------------");
            float popEng = 0;
            float popChina = 0;
            float popHindi = 0;
            float popSpanish = 0;
            float popArabic = 0;
            float popOther = 0;
            while (rset.next()){
                ctl = new CountryLanguage();
                ctl.setLanguage(rset.getString("countrylanguage.Language"));
                ctl.setPercentage(rset.getFloat("countrylanguage.Percentage"));
                ctl.setPopulation(rset.getInt("country.Population"));

                String lan;
                float per, pop;

                lan = ctl.getLanguage();
                per = ctl.getPercentage();
                pop = ctl.getPopulation();

                switch (lan) {
                    case "English":
                        popEng += per * pop / 100;
                        break;
                    case "Chinese":
                        popChina += per * pop / 100;
                        break;
                    case "Hindi":
                        popHindi += per * pop / 100;
                        break;
                    case "Spanish":
                        popSpanish += per * pop / 100;
                        break;
                    case "Arabic":
                        popArabic += per * pop / 100;
                        break;
                    default:
                        popOther += per * pop / 100;
                        break;
                }
            }
            float popTotal = totalWorldPop();
            float perEng, perChina, perHindi, perSpanish, perArabic, perOther;
            perEng = popEng/popTotal*100;
            perChina = popChina/popTotal*100;
            perHindi = popHindi/popTotal*100;
            perSpanish = popSpanish/popTotal*100;
            perArabic = popArabic/popTotal*100;
            perOther = popOther/popTotal*100;
            System.out.println(
                    "Chinese : " + popChina + String.format("%s%.2f%s"," (", perChina,"%) ") + "\n" +
                    "Hindi : " + popHindi + String.format("%s%.2f%s"," (", perHindi,"%) ")  + "\n" +
                    "Spanish : " + popSpanish + String.format("%s%.2f%s"," (", perSpanish,"%) ")  + "\n" +
                    "English : " + popEng + String.format("%s%.2f%s"," (", perEng,"%) ") + "\n" +
                    "Arabic : " + popArabic + String.format("%s%.2f%s"," (", perArabic,"%) ")  + "\n" +
                    "Other : " + popOther + String.format("%s%.2f%s"," (", perOther,"%) ")  + "\n" +
                    "_________________________"
            );
            return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }


    /**
     * Ask top number of country,
     * city, capital cit for output
     */
    int askTopNumber(String str) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter number of " + str + " : ");
        int num = myObj.nextInt();
        System.out.println("_________________________");
        return num;
    }


    public String askContinent()
    {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println(
                "Choose one of the following continent " + "\n" +
                        "('Asia','Europe','North America','Africa','Oceania','Antarctica','South America')");
        System.out.print("Enter a continent : ");
        String continent = myObj.nextLine();
        System.out.println("_________________________");
        return continent;
    }

    String askCountry()
    {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print(
                "Enter a country : ");
        String country = myObj.nextLine();
        System.out.println("_________________________");
        return country;
    }


    public String askRegion()
    {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print(
                "Choose a region of the world (eg. Southeast Asia) : ");
        String region = myObj.nextLine();
        System.out.println("_________________________");
        return region;
    }


    public String askDistrict()
    {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print(
                "Enter a region (eg. Mandalay) : ");
        String district = myObj.nextLine();
        System.out.println("_________________________");
        return district;
    }


    public String askCity()
    {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print(
                "Enter a city (eg. Mandalay) : ");
        String city = myObj.nextLine();
        System.out.println("_________________________");
        return city;
    }

    private boolean askQuestion() {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Do you want to continue? (Yes/No) : ");
        String askQ = myObj.nextLine();  // Read user input
        askQ = askQ.toLowerCase();

        if (askQ.equals("yes"))
        {
            System.out.println("_________________________");
            return true;
        }
        else if (askQ.equals("no"))
        {
            System.out.println("_________________________");
            return false;
        }
        else
        {
            System.out.println("Wrong Input!!! Try Again.");
            return askQuestion();
        }
    }


    /**
     * All the countries in the world
     * organised by largest population to smallest.
     * @return
     */
    public Country getCountry(int num)
    {
        try
        {
            Country ctry = null;
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect;
            if (num == 99999){
                strSelect =
                        "SELECT Code, Name, Continent, Region, Population, Capital "
                                + "FROM country "
                                + "ORDER BY Population DESC";
            }
            else{
                strSelect =
                        "SELECT Code, Name, Continent, Region, Population, Capital "
                                + "FROM country "
                                + "ORDER BY Population DESC LIMIT "+ num;
            }
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
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        }
        return null;
    }


    /**
     * All the countries in a continent
     * organised by largest population to smallest.
     */
    public ArrayList<Country> getCountryInContinent(String continent, int num)
    {
        ArrayList<Country> countries=null;
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create Asia string for SQL statement
            String strCont;
            if (num == 99999)
            {
                strCont =
                        "SELECT Code, Name, Continent, Region, Population, Capital "
                                + "FROM country WHERE continent = " + "\"" + continent + "\"" +
                                " ORDER BY Population DESC";
            }
            else
            {
                strCont =
                        "SELECT Code, Name, Continent, Region, Population, Capital "
                                + "FROM country WHERE continent = " + "\"" + continent + "\"" +
                                " ORDER BY Population DESC LIMIT " + num;
            }
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
    public ArrayList<Country> getCountryInRegion(String region, int num)
    {
        ArrayList<Country> countries=null;
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create Asia string for SQL statement
            String strCont;
            if (num == 99999)
            {
                strCont =
                        "SELECT Code, Name, Continent, Region, Population, Capital "
                                + "FROM country WHERE Region = " + "\"" + region + "\""
                                + " ORDER BY Population DESC";
            }
            else
            {
                strCont =
                        "SELECT Code, Name, Continent, Region, Population, Capital "
                                + "FROM country WHERE Region = " + "\"" + region + "\""
                                + " ORDER BY Population DESC LIMIT " + num;
            }

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
     * @return
     */
    public City getSpecificCity(int id) {
        City city = null;
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
    public void getCity(int num) {
        City city;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect;
            if (num == 99999)
            {
                strSelect = "SELECT city.Name, city.District, city.Population, country.Name "
                        +"FROM city "
                        +"INNER JOIN country ON country.Code=city.CountryCode "
                        + "ORDER BY city.Population DESC";
            }
            else
            {
                strSelect = "SELECT city.Name, city.District, city.Population, country.Name "
                        +"FROM city "
                        +"INNER JOIN country ON country.Code=city.CountryCode "
                        + "ORDER BY city.Population DESC LIMIT " + num;
            }
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
    }


    /**
     * All the cities in a continent
     * organised by largest population to smallest.
     */
    public void getCitiesContinent(String continent, int num) {
        City city;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect;
            if (num == 99999)
            {
                strSelect = "SELECT city.Name, city.District, city.Population, country.Name "
                        +"FROM city "
                        +"INNER JOIN country ON country.Code=city.CountryCode "
                        +"WHERE country.Continent = " + "\"" + continent + "\""
                        +" ORDER BY city.Population DESC";
            }
            else
            {
                strSelect = "SELECT city.Name, city.District, city.Population, country.Name "
                        +"FROM city "
                        +"INNER JOIN country ON country.Code=city.CountryCode "
                        +"WHERE country.Continent = " + "\"" + continent + "\""
                        +" ORDER BY city.Population DESC LIMIT " + num;
            }
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
    }


    /**
     * All the cities in a region
     * organised by largest population to smallest.
     */
    public void getCitiesRegion(String region, int num) {
        City city;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect;
            if (num == 99999)
            {
                strSelect = "SELECT city.Name, city.District, city.Population, country.Name "
                        +"FROM city "
                        +"INNER JOIN country ON country.Code=city.CountryCode "
                        +"WHERE country.Region = " + "\"" + region + "\""
                        +" ORDER BY city.Population DESC";
            }
            else
            {
                strSelect = "SELECT city.Name, city.District, city.Population, country.Name "
                        +"FROM city "
                        +"INNER JOIN country ON country.Code=city.CountryCode "
                        +"WHERE country.Region = " + "\"" + region + "\""
                        +" ORDER BY city.Population DESC LIMIT " + num;
            }
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
    }


    /**
     * All the cities in a district
     * organised by largest population to smallest.
     */
    public void getCitiesDistrict(int num) {
        City city;
        try{
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.print(
                    "Enter a district of the world : ");
            String district = myObj.nextLine();
            System.out.println("_________________________");

            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect;
            if (num == 99999)
            {
                strSelect = "SELECT city.Name, city.District, city.Population, country.Name "
                        +"FROM city "
                        +"INNER JOIN country ON country.Code=city.CountryCode "
                        +"WHERE city.District = " + "\"" + district + "\""
                        +" ORDER BY city.Population DESC";
            }
            else
            {
                strSelect = "SELECT city.Name, city.District, city.Population, country.Name "
                        +"FROM city "
                        +"INNER JOIN country ON country.Code=city.CountryCode "
                        +"WHERE city.District = " + "\"" + district + "\""
                        +" ORDER BY city.Population DESC LIMIT " + num;
            }
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
    }


    /**
     * All the cities in a district
     * organised by largest population to smallest.
     */
    public void getCitiesCountry(String country, int num) {
        City city;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect;
            if (num == 99999)
            {
                strSelect = "SELECT city.Name, city.District, city.Population, country.Name "
                        +"FROM city "
                        +"INNER JOIN country ON country.Code=city.CountryCode "
                        +"WHERE country.Name = " + "\"" + country + "\""
                        +" ORDER BY city.Population DESC";
            }
            else
            {
                strSelect = "SELECT city.Name, city.District, city.Population, country.Name "
                        +"FROM city "
                        +"INNER JOIN country ON country.Code=city.CountryCode "
                        +"WHERE country.Name = " + "\"" + country + "\""
                        +" ORDER BY city.Population DESC LIMIT " + num;
            }
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
    }


    /**
     * All the capital cities in the world
     * organised by largest population to smallest.
     */
    public void getCapitalWorld(int num) {
        City city;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect;
            if (num == 99999)
            {
                strSelect = "SELECT city.Name, city.Population, country.Name "
                        +"FROM city "
                        +"INNER JOIN country ON country.Capital=city.ID "
                        +" ORDER BY city.Population DESC";
            }
            else
            {
                strSelect = "SELECT city.Name, city.Population, country.Name "
                        +"FROM city "
                        +"INNER JOIN country ON country.Capital=city.ID "
                        +" ORDER BY city.Population DESC LIMIT " + num;
            }
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
    }


    /**
     * All the capital cities in the world
     * organised by largest population to smallest.
     */
    public void getCapitalContinent(String continent, int num) {
        City city;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect;
            if (num == 99999)
            {
                strSelect = "SELECT city.Name, city.Population, country.Name "
                        +"FROM city "
                        +"INNER JOIN country ON country.Capital=city.ID "
                        +"WHERE country.Continent = " + "\"" + continent + "\""
                        +" ORDER BY city.Population DESC";
            }
            else
            {
                strSelect = "SELECT city.Name, city.Population, country.Name "
                        +"FROM city "
                        +"INNER JOIN country ON country.Capital=city.ID "
                        +"WHERE country.Continent = " + "\"" + continent + "\""
                        +" ORDER BY city.Population DESC LIMIT " + num;
            }
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
    }


    /**
     * All the capital cities in a region
     * organised by largest to smallest.
     */
    public void getCapitalRegion(String region, int num) {
        City city;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect;
            if (num == 99999)
            {
                strSelect = "SELECT city.Name, city.Population, country.Name "
                        +"FROM city "
                        +"INNER JOIN country ON country.Capital=city.ID "
                        +"WHERE country.Region = " + "\"" + region + "\""
                        +" ORDER BY city.Population DESC";
            }
            else
            {
                strSelect = "SELECT city.Name, city.Population, country.Name "
                        +"FROM city "
                        +"INNER JOIN country ON country.Capital=city.ID "
                        +"WHERE country.Region = " + "\"" + region + "\""
                        +" ORDER BY city.Population DESC LIMIT " + num;
            }
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
    }


    /**
     * Total population in a specific district
     */
    public void totalPopuDistrict(String district) {
        City cty;
        int totalPopulation = 0;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT District, Population FROM city WHERE District=" + "\"" + district + "\"";
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
                    cty=new City();
                    cty.setDistrict(rset.getString("District"));
                    cty.setPopulation(rset.getInt("Population"));
                    totalPopulation += cty.getPopulation();
                }
                System.out.println("Total Population of " + district + " : " + totalPopulation);
                System.out.println("_____________________________");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get data!");
        }
    }


    /**
     * Total population in a specific city
     */
    public void totalPopuCity(String city) {
        City cty;
        int totalPopulation = 0;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Population FROM city WHERE Name=" + "\"" + city + "\"";
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
                    cty=new City();
                    cty.setPopulation(rset.getInt("Population"));
                    totalPopulation += cty.getPopulation();
                }
                System.out.println("Total Population of " + city + " : " + totalPopulation);
                System.out.println("_____________________________");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get data!");
        }
    }


    /**
     * Total population in a specific region
     */
    public int totalPopuRegion(String region) {
        Country cont;
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
        Country cont;
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
        int notLiveCities;
        double perLiveCities;
        double perNotLiveCities;
        notLiveCities = total - liveCities;
        //per = (liveCities*100)/total;
        perLiveCities = (double) liveCities / (double) total *100;
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
        Country cont;
        double totalPopulation = 0;
        try{
            //Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Name, Population, Continent FROM country WHERE continent=" + "\"" + continent + "\"";
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
                    cont.setContinent(rset.getString("Continent"));
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
        Country cont;
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
        int notLiveCities;
        double perLiveCities;
        double perNotLiveCities;
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
        Country cont;
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
        Country cont;
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
    public void populationCountry(double total, double liveCities, String country)
    {
        int notLiveCities;
        double perLiveCities;
        double perNotLiveCities;
        notLiveCities = (int) (total - liveCities);
        perLiveCities = liveCities/total*100;
        perNotLiveCities = 100 - perLiveCities;
        System.out.println("Population Report in "+ country);
        System.out.println("-----------------------------------------");
        System.out.println(
                "Continent : " + country + "\n" +
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
                System.out.println("Failed to connect to database attempt " + i);
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