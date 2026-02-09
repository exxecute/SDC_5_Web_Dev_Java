package com.webdev.sdc.config;

public enum RepositoryType {
    FILE("file"),
    JDBC("jdbc");

    private final String value;

    RepositoryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RepositoryType from(String value) {
        for (RepositoryType type : values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown repository type: " + value);
    }
}
