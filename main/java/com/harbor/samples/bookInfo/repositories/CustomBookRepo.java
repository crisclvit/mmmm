package com.harbor.samples.bookInfo.repositories;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harbor.samples.bookInfo.models.Book;

@Service
public class CustomBookRepo {
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CustomBookRepo.class);

    @Autowired
    EntityManager entityManager;

    public List<Book> getBookByName(String name) {
        LOGGER.info("Getting book with name: {}", name);
        String jql = "from book where title = '" + name + "'";
        TypedQuery<Book> q = entityManager.createQuery(jql, Book.class);
        return q.getResultList();
    }
}
