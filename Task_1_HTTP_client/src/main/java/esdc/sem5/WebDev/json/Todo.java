package esdc.sem5.WebDev.json;

public record Todo(
        Integer id,
        Integer userId,
        String title,
        Boolean completed
) {
    public String toJson() {
        return String.format("""
                        {
                          "id": %s,
                          "userId": %s,
                          "title": "%s",
                          "completed": %s
                        }
                        """,
                id == null ? "null" : id,
                userId == null ? "null" : userId,
                title,
                completed);
    }
}
