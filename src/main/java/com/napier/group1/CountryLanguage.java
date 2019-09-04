package com.napier.group1;

public class CountryLanguage {
    private String Language;

    private float Percentage;

    private float Population;

    public CountryLanguage(String language, float percentage, float population) {
        Language = language;
        Percentage = percentage;
        Population = population;
    }

    public CountryLanguage() {
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "Language='" + Language + '\'' +
                ", Percentage=" + Percentage +
                ", Population=" + Population +
                '}';
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public float getPercentage() {
        return Percentage;
    }

    public void setPercentage(float percentage) {
        Percentage = percentage;
    }

    public float getPopulation() {
        return Population;
    }

    public void setPopulation(float population) {
        Population = population;
    }
}
