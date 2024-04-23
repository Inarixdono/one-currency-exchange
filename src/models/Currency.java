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

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getInstance();
        return formatter.format(amount) + " " + baseCode;
    }
}
