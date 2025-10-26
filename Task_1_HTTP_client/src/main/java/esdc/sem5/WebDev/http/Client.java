package esdc.sem5.WebDev.http;

import esdc.sem5.WebDev.json.Todo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Client implements HttpService {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/todos/";
    private final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    @Override
    public void getAll() {
        exec(HttpRequest.newBuilder(URI.create(BASE_URL))
                .GET()
                .timeout(Duration.ofSeconds(10))
                .build());
    }

    @Override
    public void getId(int id) {
        exec(HttpRequest.newBuilder(URI.create(BASE_URL + id))
                .GET()
                .timeout(Duration.ofSeconds(10))
                .build());
    }

    @Override
    public void post(Todo todo) {
        exec(HttpRequest.newBuilder(URI.create(BASE_URL))
                .header("Content-Type", "application/json; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(todo.toJson()))
                .timeout(Duration.ofSeconds(10))
                .build());
    }

    @Override
    public void put(Todo todo) {
        if (todo.id() == null) {
            System.out.println("PUT requires an ID!");
            return;
        }
        exec(HttpRequest.newBuilder(URI.create(BASE_URL + todo.id()))
                .header("Content-Type", "application/json; charset=UTF-8")
                .PUT(HttpRequest.BodyPublishers.ofString(todo.toJson()))
                .timeout(Duration.ofSeconds(10))
                .build());
    }

    @Override
    public void delete(int id) {
        exec(HttpRequest.newBuilder(URI.create(BASE_URL + id))
                .DELETE()
                .timeout(Duration.ofSeconds(10))
                .build());
    }

    private void exec(HttpRequest request) {
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("HTTP " + response.statusCode());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            System.out.println("Request error: " + e.getMessage());
        }
    }
}
