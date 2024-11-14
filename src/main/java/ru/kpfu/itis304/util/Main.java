package ru.kpfu.itis304.util;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws MalformedURLException {

        Client client = new Client();

        String url = "https://jsonplaceholder.typicode.com/posts";
        Map<String, String> getHeaders =  new HashMap<>();
        getHeaders.put("Content-Type", "application/json");
        getHeaders.put("Accept", "application/json");
        Map<String, String> getData = new HashMap<>();
        getData.put("userId", "2");
        getData.put("id", "13");
        System.out.println(client.get(url, getHeaders, getData));


        Map<String, String> headersToPost =  new HashMap<>();
        headersToPost.put("Content-Type", "application/json");
        headersToPost.put("Accept", "application/json");
        headersToPost.put("Authorization", "Bearer 58762cdab4e248c10d165f6bbe89d18a444dff00267b6cfcec49acf9dceb94b7");
        Map<String, String> postData = new HashMap<>();
        postData.put("title", "welcome");
        postData.put("body", "hello world");
        System.out.println(client.post(url, headersToPost, postData));


        Map<String, String> putHeaders =  new HashMap<>();
        putHeaders.put("Content-Type", "application/json");
        putHeaders.put("Accept", "application/json");
        putHeaders.put("Authorization", "Bearer 58762cdab4e248c10d165f6bbe89d18a444dff00267b6cfcec49acf9dceb94b7");
        Map<String, String> putData = new HashMap<>();
        putData.put("title", "srabotalo");
        putData.put("body", "yra!");
        System.out.println(client.put("https://jsonplaceholder.typicode.com/posts/1", putHeaders, putData));


        Map<String, String> deleteHeaders =  new HashMap<>();
        deleteHeaders.put("Content-Type", "application/json");
        deleteHeaders.put("Accept", "application/json");
        System.out.println(client.delete("https://jsonplaceholder.typicode.com/posts/1", deleteHeaders, null));


    }
}
