package com.harbor.samples.bookInfo.models;

import java.io.Serializable;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO implements Serializable {
    private Long id;

    private String firstName;
    private String lastName;

    private String emailId;
    private String mobileNumber;

    private long createdAt;

    private String loginName;

    private Set<ReviewDTO> reviews;
}
