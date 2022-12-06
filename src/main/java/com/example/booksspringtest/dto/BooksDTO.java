package com.example.booksspringtest.dto;

import lombok.Data;

@Data
public class BooksDTO {

    Long id;
    String authorName;
    String bookName;
    int pageCount;
}
