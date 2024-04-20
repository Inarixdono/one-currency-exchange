package models;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Currency {

    private double rate;
    private String baseCode;
    private JsonObject conversionRates;

    public Currency(String currency, double rate) throws IOException, InterruptedException {
        this.rate = rate;
        this.baseCode = currency;
        this.conversionRates = setConversionRates();;
    }

    public String getBaseCode() {
        return baseCode;
    }

    private JsonObject setConversionRates() throws IOException, InterruptedException {
       return this.conversionRates = ConversionRatesFinder.getConversionRates(this);
    }

    @Override
    public String toString() {
        return "Currency: " + baseCode + " Rate: " + rate;
    }
}
