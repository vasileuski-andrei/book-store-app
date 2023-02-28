package com.idf.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idf.model.Book;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ParserService {

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
