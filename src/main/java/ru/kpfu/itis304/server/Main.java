package ru.kpfu.itis304.server;

import ru.kpfu.itis304.les1.Client;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();

        Map<String, String> headers =  new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        headers.put("Authorization", "Bearer 58762cdab4e248c10d165f6bbe89d18a444dff00267b6cfcec49acf9dceb94b7");

        Map<String, String> postData = new HashMap<>();
        postData.put("id", "1");
        postData.put("title", "welcome");
        postData.put("body", "hello world");
        System.out.println(client.post("http://localhost:8080", headers, postData));


        Map<String, String> getData = new HashMap<>();
        getData.put("id", "1");
        System.out.println(client.get("http://localhost:8080", headers, getData));


        Map<String, String> putData = new HashMap<>();
        putData.put("title", "srabotalo");
        putData.put("body", "yra!");
        System.out.println(client.put("http://localhost:8080", headers, putData));


        Map<String, String> deleteHeaders =  new HashMap<>();
        System.out.println(client.delete("http://localhost:8080", deleteHeaders, null));



    }
}
