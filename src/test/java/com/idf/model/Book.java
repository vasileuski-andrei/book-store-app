package com.idf.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    private String isbn;
    private String title;
    private String subTitle;
    private String author;
    private String publish_date;
    private String publisher;
    private String pages;
    private String description;
    private String website;

}
