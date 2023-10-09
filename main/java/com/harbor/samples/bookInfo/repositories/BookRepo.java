package com.harbor.samples.bookInfo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.harbor.samples.bookInfo.models.Book;

@Service
public interface BookRepo extends CrudRepository<Book, Long> {
    @Query(value = "SELECT * FROM book WHERE name = ?1", nativeQuery = true)
    Book findByName(String name);

}
