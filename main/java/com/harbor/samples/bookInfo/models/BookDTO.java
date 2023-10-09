package com.harbor.samples.bookInfo.models;

import java.io.Serializable;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO implements Serializable {
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private String publisher;

    private long createdAt;

    private String creditCardNumber;
    private Set<ReviewDTO> reviews;

}
