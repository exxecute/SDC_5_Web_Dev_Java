package esdc.sem5.WebDev.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Client {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public Client() {

    }

    public void getId(int id) {
        exec(HttpRequest.newBuilder(URI.create(BASE_URL + id))
                .GET().timeout(Duration.ofSeconds(20)).build());
    }

    public void getAll() {
        exec(HttpRequest.newBuilder(URI.create(BASE_URL))
                .GET().timeout(Duration.ofSeconds(20)).build());
    }

    public void delete(int id) {
        HttpResponse<String> resp = exec(HttpRequest.newBuilder(URI.create(BASE_URL + id))
                .DELETE()
                .timeout(Duration.ofSeconds(5))
                .build());

        if (resp != null && (resp.statusCode() == 200 || resp.statusCode() == 204)) {
            System.out.println("Deleted id " + id);
        }
    }

    private HttpResponse<String> exec(HttpRequest req) {
        HttpResponse<String> resp = null;
        try {
            resp = client.send(req, HttpResponse.BodyHandlers.ofString());
            System.out.println("HTTP " + resp.statusCode());
            System.out.println(resp.headers().map());
            System.out.println(resp.body());
        } catch (RuntimeException | IOException | InterruptedException e) {
            System.out.println("Error");
        }
        return resp;
    }
}
