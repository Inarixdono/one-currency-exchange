package models;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.io.IOException;

import interfaces.Representable;

/**
 * Represents a currency with its amount, country, and base code.
 * Implements the Representable interface.
 */
public class Currency implements Representable {

    private double amount;
    private String country;
    private String baseCode;
    private static ArrayList<Representable> currencies = new ArrayList<>();

    /**
     * Constructs a Currency object with the specified base code and initializes the amount to 0.
     * @param baseCode the base code of the currency
     */
    public Currency(String baseCode) {
        this.baseCode = baseCode;
        this.amount = 0;
    }

    /**
     * Constructs a Currency object with the specified base code and country, and initializes the amount to 0.
     * @param baseCode the base code of the currency
     * @param country the country associated with the currency
     */
    public Currency(String baseCode, String country) {
        this.baseCode = baseCode;
        this.country = country;
        this.amount = 0;
    }

    /**
     * Constructs a Currency object with the specified base code and rate.
     * @param baseCode the base code of the currency
     * @param rate the rate of the currency
     */
    public Currency(String baseCode, double rate) {
        this.amount = rate;
        this.baseCode = baseCode;
    }

    /**
     * Gets the base code of the currency.
     * @return the base code of the currency
     */
    public String getBaseCode() {
        return baseCode;
    }

    /**
     * Gets the amount of the currency.
     * @return the amount of the currency
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the country associated with the currency.
     * @return the country associated with the currency
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the amount of the currency.
     * @param rate the rate of the currency
     */
    public void setAmount(double rate) {
        this.amount = rate;
    }

    /**
     * Returns a string representation of the currency.
     * @return a string representation of the currency
     */
    public String representation() {
        return baseCode + " " + country;
    }

    /**
     * Requests the amount of the currency from the user.
     * @param scanner the scanner object used for user input
     */
    public void resquestAmount(Scanner scanner) {
        System.out.print("Enter the amount in " + baseCode + ": ");

        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            resquestAmount(scanner);
        }
    }

    /**
     * Converts the currency to the specified currency using an Exchanger object.
     * @param toConvert the currency to convert to
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the thread is interrupted
     */
    public void convertTo(Currency toConvert) throws IOException, InterruptedException {
        Exchanger converter = new Exchanger();
        converter.converTo(this, toConvert);
    }

    /**
     * Gets a list of currencies.
     * @return the list of currencies
     */
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

    /**
     * Returns a string representation of the currency.
     * @return a string representation of the currency
     */
    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getInstance();
        return formatter.format(amount) + " " + baseCode;
    }
}
