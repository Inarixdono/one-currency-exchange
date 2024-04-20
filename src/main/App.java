package main;

import java.io.IOException;
import java.util.Scanner;

import com.google.gson.JsonObject;

import models.Currency;

public class App{
    public static void main(String[] args) throws IOException, InterruptedException{

        double amount;
        Currency currency;
        JsonObject conversionRates;
        String exchangingCurrency;
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the currency you want to exchange: ");
        exchangingCurrency = scan.nextLine();
        System.out.print("Enter the amount you want to exchange: ");
        amount = scan.nextDouble();
        scan.close();

        currency = new Currency(exchangingCurrency, amount);
        

    }
}