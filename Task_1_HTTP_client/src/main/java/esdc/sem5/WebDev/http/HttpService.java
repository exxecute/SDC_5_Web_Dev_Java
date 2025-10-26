package esdc.sem5.WebDev.http;

import esdc.sem5.WebDev.json.Todo;

public interface HttpService {
    void getAll();
    void getId(int id);
    void post(Todo todo);
    void put(Todo todo);
    void delete(int id);
}
