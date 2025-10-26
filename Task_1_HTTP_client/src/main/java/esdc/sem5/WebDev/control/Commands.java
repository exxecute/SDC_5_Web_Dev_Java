package esdc.sem5.WebDev.control;

public enum Commands {
    GET_ONE("GET_ONE"),
    GET_ALL("GET_ALL"),
    DELETE("DELETE"),
    POST("POST"),
    PUT("PUT"),
    SOLID("SOLID"),
    KISS("KISS"),
    EXIT("EXIT");

    private final String value;

    Commands(String value) {
        this.value = value;
    }

    public static Commands fromString(String text) {
        for (Commands cmd : Commands.values()) {
            if (cmd.value.equalsIgnoreCase(text)) {
                return cmd;
            }
        }
        throw new IllegalArgumentException("Unknown command: " + text);
    }
}
