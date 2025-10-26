package esdc.sem5.WebDev;

import esdc.sem5.WebDev.control.Control;

import java.util.Scanner;

public class Main {
    private static final Control CONTROL = new Control();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        while (CONTROL.processUserInput(SCANNER)) {
            System.out.println("------");
        }
    }
}