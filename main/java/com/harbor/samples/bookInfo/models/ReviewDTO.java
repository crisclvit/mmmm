package com.harbor.samples.bookInfo.models;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDTO implements Serializable {
    private Long id;

    private int rating;
    private String comment;

    private String sentiment;

    private long createdAt;

    private Long byUserId;

    private Long forBookId;
}
