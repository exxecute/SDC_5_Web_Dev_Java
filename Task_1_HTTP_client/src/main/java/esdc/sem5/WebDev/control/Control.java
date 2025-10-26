package esdc.sem5.WebDev.control;


import esdc.sem5.WebDev.http.Client;
import esdc.sem5.WebDev.json.Todo;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Control {
    private static final Client CLIENT = new Client();
    private static final Map<Commands, java.util.function.Function<Scanner, Boolean>> COMMANDS = Map.of(
        Commands.GET_ONE, Control::getOne,
        Commands.GET_ALL, Control::getAll,
        Commands.DELETE, Control::delete,
        Commands.POST, Control::post,
        Commands.PUT, Control::put,
        Commands.EXIT, Control::exit
    );

    public Control() { }

    public boolean processUserInput(Scanner scanner) {
        this.showCommands();

        try {
            return COMMANDS.get(Commands.fromString(getCommand(scanner))).apply(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private void showCommands() {
        System.out.println("Enter the following command:");
        for (Commands cmd : Commands.values()) {
            System.out.print(" - ");
            System.out.println(cmd);
        }
    }

    private String getCommand(Scanner sc) {
        System.out.print("input:");
        return sc.next().toUpperCase(Locale.ROOT);
    }

    private static boolean getOne(Scanner scanner) {
        System.out.println("Get One");
        CLIENT.getId(getId(scanner));
        return true;
    }

    private static boolean getAll(Scanner scanner) {
        CLIENT.getAll();
        return true;
    }

    private static boolean delete(Scanner scanner) {
        CLIENT.delete(getId(scanner));
        return true;
    }

    private static boolean put(Scanner scanner) {
        CLIENT.put(getToDo(scanner));
        return true;
    }

    private static boolean post(Scanner scanner) {
        CLIENT.post(getToDo(scanner));
        return true;
    }

    private static boolean exit(Scanner scanner) {
        System.out.println("Exiting...");
        return false;
    }

    private static int getId(Scanner scanner) {
        boolean isLoop = true;
        int id = 0;
        do {
            System.out.print("Enter an id:");
            id = scanner.nextInt();

            if (id <= 0) {
                System.out.println("incorrect input");
            } else {
                isLoop = false;
                CLIENT.getId(id);
            }
        } while (isLoop);
        return id;
    }

    private static Todo getToDo(Scanner scanner) {
        scanner.nextLine();
        System.out.print("ID: ");
        String idInput = scanner.nextLine();
        Integer id = idInput.isBlank() ? null : Integer.parseInt(idInput);

        System.out.print("User ID: ");
        String userIdInput = scanner.nextLine();
        Integer userId = userIdInput.isBlank() ? null : Integer.parseInt(userIdInput);

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Completed (true/false): ");
        String completedInput = scanner.nextLine();
        Boolean completed = completedInput.isBlank() ? null : Boolean.parseBoolean(completedInput);
        return new Todo(id, userId, title, completed);
    }
}
