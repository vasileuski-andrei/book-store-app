package com.idf.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idf.model.Book;
import com.idf.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ApiService {

    public String createNewUserThroughApi(String strUrl, String password) {
        String login = CommonUtil.getRandomString(5);
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            HttpUriRequest httppost = RequestBuilder.post()
                    .setUri(new URI(strUrl))
                    .addParameter("userName", login)
                    .addParameter("password", password)
                    .build();

            httpclient.execute(httppost);

            log.info("User with name " + login + " was successfully created via API service");

        } catch (URISyntaxException | IOException e) {
            log.info("User wasn't created " + "\n" + e);
        }

        return login;
    }

    public List<Book> getDataFromApi(String strUrl) throws IOException {
        List<Book> books = new ArrayList<>();
        URL url = new URL(strUrl);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNodeBooks = mapper.readTree(url).get("books");
        for (JsonNode jsonNodeBook : jsonNodeBooks) {
            Book book = mapper.treeToValue(jsonNodeBook, Book.class);
            books.add(book);
        }

        log.info("Books from API were loaded");

        return books;

    }

}
