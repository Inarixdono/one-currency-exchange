package models;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.io.IOException;

import interfaces.Representable;

public class Currency implements Representable {

    private double amount;
    private String country;
    private String baseCode;
    private static ArrayList<Representable> currencies = new ArrayList<>();

    public Currency(String baseCode) {
        this.baseCode = baseCode;
        this.amount = 0;
    }

    public Currency(String baseCode, String country) {
        this.baseCode = baseCode;
        this.country = country;
        this.amount = 0;
    }

    public Currency(String baseCode, double rate) {
        this.amount = rate;
        this.baseCode = baseCode;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public double getAmount() {
        return amount;
    }

    public String getCountry() {
        return country;
    }

    public void setAmount(double rate) {
        this.amount = rate;
    }

    public String representation() {
        return baseCode + " " + country;
    }

    public void resquestAmount(Scanner scanner) {
        System.out.print("Enter the amount in " + baseCode + ": ");

        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            resquestAmount(scanner);
        }
    }

    public void convertTo(Currency toConvert) throws IOException, InterruptedException {
        Exchanger converter = new Exchanger();
        converter.converTo(this, toConvert);
    }

    public static ArrayList<Representable> getCurrencies() {
        currencies = new ArrayList<>(Arrays.asList(
                new Currency("USD", "United States"),
                new Currency("EUR", "European Union"),
                new Currency("ARS", "Argentina"),
                new Currency("BOB", "Bolivia"),
                new Currency("BRL", "Brazil"),
                new Currency("COP", "Colombia"),
                new Currency("CLP", "Chile"),
                new Currency("DOP", "Dominican Republic"),
                new Currency("MXN", "Mexico"),
                new Currency("PEN", "Peru")));

        return currencies;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getInstance();
        return formatter.format(amount) + " " + baseCode;
    }
}
