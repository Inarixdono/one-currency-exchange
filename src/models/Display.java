package models;

import java.util.ArrayList;
import java.util.Scanner;

import interfaces.Representable;

/**
 * The Display class represents a display interface for interacting with the user.
 * It provides methods for printing messages, displaying lists, and selecting items.
 */
public class Display {
    private Scanner scanner;
    private String reprType;
    private boolean isRunning;
    private int displayLength;
    private ArrayList<Representable> list;

    /**
     * Constructs a Display object with the specified representation type, scanner, and list of items.
     *
     * @param reprType the representation type of the items
     * @param scanner the scanner object used for user input
     * @param list the list of items to be displayed
     */
    public Display(String reprType, Scanner scanner, ArrayList<Representable> list) {
        this.list = list;
        this.isRunning = true;
        this.displayLength = 60;
        this.scanner = scanner;
        this.reprType = reprType;
    }

    /**
     * Returns the scanner object used for user input.
     *
     * @return the scanner object
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * Checks if the display is running.
     *
     * @return true if the display is running, false otherwise
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Turns off the display.
     */
    private void turnOff() {
        this.isRunning = false;
    }

    /**
     * Prints the specified message.
     *
     * @param message the message to be printed
     */
    private void print(String message) {
        System.out.print(message);
    }

    /**
     * Prints the specified message followed by a new line.
     *
     * @param message the message to be printed
     */
    private void println(String message) {
        System.out.println(message);
    }

    /**
     * Clears the console screen.
     */
    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Checks if the specified string is numeric.
     *
     * @param str the string to be checked
     * @return true if the string is numeric, false otherwise
     */
    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * Waits for the user to press enter.
     */
    public void waitForUser()  {
        print("Press enter to continue...");
        scanner.nextLine();
        clearConsole();
    }

    /**
     * Prints the list of items.
     */
    private void printList() {
        Representable item;

        println("-".repeat(displayLength));

        for (int i = 0; i < list.size(); i++) {
            item = list.get(i);
            println(String.format("%-4s", i + 1 + ".") + item.representation());
        }

        println("-".repeat(displayLength) + "\n");
    }

    /**
     * Displays the specified message to the user.
     *
     * @param message the message to be displayed
     */
    public void showMessage(String message) {
        clearConsole();
        println("-".repeat(displayLength) + "\n");
        println(message);
        println("\n" + "-".repeat(displayLength));
        waitForUser();
    }

    /**
     * Allows the user to select an item from the list.
     *
     * @param message the message to be displayed before selecting an item
     * @return the selected item
     */
    public Representable selectItem(String message) {
        int index;
        String input;
        Representable item;

        println(message + "\n");
        printList();
        print("or enter \".\" to exit: ");
        input = scanner.nextLine();

        if (input.equals(".")) {
            turnOff();
            throw new IndexOutOfBoundsException();
        }

        if (isNumeric(input)) {
            index = Integer.valueOf(input);

            try {
                item = list.get(index - 1);
                message = "Selected " + reprType.toLowerCase() + ": " + item.representation();
                showMessage(message);
            } catch (IndexOutOfBoundsException e) {
                message = index + " does not exist. Please select a valid " + reprType.toLowerCase() + ".";
                showMessage(message);
                item = selectItem(message);
            }

        } else {
            showMessage("Invalid input. Please enter a valid option.");
            item = selectItem(message);
        }

        return item;
    }
}
