package esdc.sem5.WebDev.control;

import esdc.sem5.WebDev.http.HttpService;

import java.util.HashMap;
import java.util.Map;

public class Control {

    private final HttpService client;
    private final InputHelper inputHelper;
    private final Map<String, CommandAction> commands = new HashMap<>();

    public Control(HttpService client, InputHelper inputHelper) {
        this.client = client;
        this.inputHelper = inputHelper;
        initCommands();
    }

    private void initCommands() {
        commands.put("GET 1", () -> { client.getId(inputHelper.readId()); return true; });
        commands.put("GET ALL", () -> { client.getAll(); return true; });
        commands.put("DELETE", () -> { client.delete(inputHelper.readId()); return true; });
        commands.put("POST", () -> { client.post(inputHelper.readTodo()); return true; });
        commands.put("PUT", () -> { client.put(inputHelper.readTodo()); return true; });
        commands.put("EXIT", () -> false);
    }

    public boolean processUserInput() {
        showCommands();
        String input = inputHelper.readCommand().toUpperCase();
        CommandAction action = commands.get(input);
        if (action != null) {
            return action.execute();
        } else {
            System.out.println("Unknown command: " + input);
            return true;
        }
    }

    private void showCommands() {
        System.out.println("Available commands: " + commands.keySet());
    }
}
