package com.harbor.samples.bookInfo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harbor.samples.bookInfo.DTOUtils;
import com.harbor.samples.bookInfo.models.Book;
import com.harbor.samples.bookInfo.models.BookDTO;
import com.harbor.samples.bookInfo.repositories.BookRepo;
import com.harbor.samples.bookInfo.repositories.CustomBookRepo;

@Service
public class BookService {
    public static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private DTOUtils dtoUtils;

    @Autowired
    private CustomBookRepo customRepo;

    public Book createBook(Book book) {
        LOGGER.info("Creating book: {}", book);
        return bookRepo.save(book);
    }

    public Book getBookById(Long id) {
        LOGGER.info("Getting book with id: {}", id);
        return bookRepo.findById(id).orElse(null);
    }

    public Book updateBook(Book book) {
        LOGGER.info("Updating book: {}", book);
        return bookRepo.save(book);
    }

    public void deleteBook(Long id) {
        LOGGER.info("Deleting book with id: {}", id);
        bookRepo.deleteById(id);
    }

    public List<BookDTO> getBookByName(String name) {
        LOGGER.info("Getting book with name: {}", name);
        return customRepo.getBookByName(name).stream().map(book -> dtoUtils.convertToBookDTO(book)).collect(Collectors.toList());
    }
}
