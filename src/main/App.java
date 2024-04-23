/**
 * The main class of the currency converter application.
 */
package main;

import models.Currency;
import models.Display;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Currency to;
        Currency from;
        String message;
        Display display = new Display("Currency", new Scanner(System.in), Currency.getCurrencies());

        do {

            display.showMessage("Welcome to the currency converter!");

            try {
                from = (Currency) display.selectItem("Choose the currency to convert from:");
                from.resquestAmount(display.getScanner());

                to = (Currency) display.selectItem("Choose the currency to convert to: ");
                from.convertTo(to);

                message = "Conversion rate: " + from + " = " + to;
                display.showMessage(message);
            } catch (IndexOutOfBoundsException e) {
                display.showMessage("User requested to exit the program. Goodbye!");
                continue;
            } catch (IOException | InterruptedException e) {
                display.showMessage("An error occurred while trying to convert the currency.");
                continue;
            }

        } while (display.isRunning());
    }
}