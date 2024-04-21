package models;

import java.util.ArrayList;
import java.util.Arrays;

public class Display {
    private ArrayList<Currency> currencies;

    public Display() {
        setCurrencies();
    }

    private void setCurrencies() {
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
            new Currency("PEN", "Peru")
        ));        
    }

    public void showCurrencies(String message) {
        String output;
        Currency currency;

        System.out.println("-".repeat(40));

        for (int i = 0; i < currencies.size(); i++){
            currency = currencies.get(i);
            output = String.format("%-4s", i + 1 + "." ) + currency.getBaseCode()
                + " - " + currency.getCountry();
            System.out.println(output);
        }

        System.out.print(message);
        System.out.println("\n" + "-".repeat(40) + "\n");
        System.out.println("Write \"99\" to exit.");
    }

    public Currency selectCurrency(int index) {
        
        Currency currency;
        
        if (index > 0 && index <= currencies.size()) {
           currency = currencies.get(index - 1);
        } else {
            throw new IndexOutOfBoundsException();
        }

        clearConsole();
        System.out.println("Selected currency: " + currency.getBaseCode());

        return currency;
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
