package esdc.sem5.WebDev;

import esdc.sem5.WebDev.control.Control;
import esdc.sem5.WebDev.control.InputHelper;
import esdc.sem5.WebDev.http.Client;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHelper inputHelper = new InputHelper(scanner);
        Client client = new Client();

        Control control = new Control(client, inputHelper);

        boolean isRunning = true;
        while (isRunning) {
            isRunning = control.processUserInput();
        }
        System.out.println("Application terminated.");
    }
}
