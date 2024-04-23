package models;

import java.util.ArrayList;
import java.util.Scanner;

import interfaces.Representable;

public class Display {
    private Scanner scanner;
    private String reprType;
    private boolean isRunning;
    private int displayLength;
    private ArrayList<Representable> list;

    public Display(String reprType, Scanner scanner, ArrayList<Representable> list) {
        this.list = list;
        this.isRunning = true;
        this.displayLength = 60;
        this.scanner = scanner;
        this.reprType = reprType;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public boolean isRunning() {
        return isRunning;
    }

    private void turnOff() {
        this.isRunning = false;
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public void waitForUser()  {
        print("Press enter to continue...");
        scanner.nextLine();
        clearConsole();
    }

    private void printList() {
        Representable item;

        println("-".repeat(displayLength));

        for (int i = 0; i < list.size(); i++) {
            item = list.get(i);
            println(String.format("%-4s", i + 1 + ".") + item.representation());
        }

        println("-".repeat(displayLength) + "\n");
    }

    public void showMessage(String message) {
        clearConsole();
        println("-".repeat(displayLength) + "\n");
        println(message);
        println("\n" + "-".repeat(displayLength));
        waitForUser();
    }

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
