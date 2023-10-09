package com.harbor.samples.bookInfo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.harbor.samples.bookInfo.models.User;

@Service
public interface UserRepo extends CrudRepository<User, Long> {
    @Query(value = "SELECT * FROM user WHERE name RLIKE '?1'", nativeQuery = true)
    User findByName(String name);
}
