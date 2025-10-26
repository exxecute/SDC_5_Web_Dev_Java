package esdc.sem5.WebDev.json;

public record Todo(
        Integer id,
        Integer userId,
        String title,
        Boolean completed
) {
}