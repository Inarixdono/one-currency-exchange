package models;

import java.io.IOException;

public class Currency {

    private double rate;
    private String baseCode;
    private String country;
    
    public Currency(String baseCode) {
        this.baseCode = baseCode;
        this.rate = 0;
    }

    public Currency(String baseCode, String country) {
        this.baseCode = baseCode;
        this.country = country;
        this.rate = 0;
    }

    public Currency(String baseCode, double rate) {
        this.rate = rate;
        this.baseCode = baseCode;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public double getRate() {
        return rate;
    }

    public String getCountry() {
        return country;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void convertTo(Currency toConvert) throws IOException, InterruptedException {
        Exchanger converter = new Exchanger();
        converter.converTo(this, toConvert);
    }

    @Override
    public String toString() {
        return rate + " " + baseCode;
    }
}
