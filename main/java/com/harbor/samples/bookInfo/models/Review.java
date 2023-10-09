package com.harbor.samples.bookInfo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "review")
@Entity(name = "review")
@Getter
@Setter
public class Review implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private int rating;
    private String comment;

    private String sentiment;

    private long createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User byUser;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    private Book forBook;

}
