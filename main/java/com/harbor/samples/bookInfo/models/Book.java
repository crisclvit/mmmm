package com.harbor.samples.bookInfo.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.Setter;

@Table(name = "book")
@Entity(name = "book")
@Getter
@Setter
public class Book implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String author;

    @Nullable
    private String isbn;
    @Nullable
    private String publisher;

    @Column(name="creationTimestamp")
    private long createdAt;

    @Nullable
    private String creditCardNumber;

    @OneToMany(mappedBy = "forBook")
    private Set<Review> reviews;
}
