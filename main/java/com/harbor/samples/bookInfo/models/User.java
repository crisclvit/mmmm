package com.harbor.samples.bookInfo.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.Setter;

@Table(name = "user")
@Entity(name = "user")
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    private String emailId;
    @Nullable
    private String mobileNumber;

    private long createdAt;

    private String loginName;

    @OneToMany(mappedBy="byUser")
    private Set<Review> reviews;
}
