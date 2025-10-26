package esdc.sem5.WebDev.control;

import esdc.sem5.WebDev.json.Todo;

import java.util.Scanner;

public class InputHelper {

    private final Scanner scanner;

    public InputHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readId() {
        int id;
        do {
            System.out.print("Enter ID: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Incorrect input. Enter a number.");
                scanner.next();
            }
            id = scanner.nextInt();
        } while (id <= 0);
        scanner.nextLine();
        return id;
    }

    public Todo readTodo() {
        System.out.print("ID (optional): ");
        String idInput = scanner.nextLine();
        Integer id = idInput.isBlank() ? null : Integer.parseInt(idInput);

        System.out.print("User ID: ");
        Integer userId = Integer.parseInt(scanner.nextLine());

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Completed (true/false): ");
        Boolean completed = Boolean.parseBoolean(scanner.nextLine());

        return new Todo(id, userId, title, completed);
    }

    public String readCommand() {
        System.out.print("Input command: ");
        return scanner.nextLine().trim();
    }
}
