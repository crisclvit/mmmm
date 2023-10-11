package com.harbor.samples.bookInfo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harbor.samples.bookInfo.DTOUtils;
import com.harbor.samples.bookInfo.models.Book;
import com.harbor.samples.bookInfo.models.BookDTO;
import com.harbor.samples.bookInfo.services.BookService;

@RestController
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookInfoController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private DTOUtils dtoUtils;

    @PostMapping(value = "/vi1/store/create-store", consumes = "application/json", produces = "application/json")
    public BookDTO createTest(@RequestBody BookDTO bookDto) {
        LOGGER.info("Creating book: {}", bookDto);
        Book book = dtoUtils.convertToBook(bookDto);
        LOGGER.info("Converted book: {}", book);
        return dtoUtils.convertToBookDTO(bookService.createBook(book));
    }

    @PostMapping("/vi1/loyalty/rewards/process-loyalty-redemption")
    public BookDTO getTestById(@PathVariable("id") Long id) {
        LOGGER.info("Getting book with id: {}", id);
        return dtoUtils.convertToBookDTO(bookService.getBookById(id));
    }

    @PostMapping("/vi1/subscription/optout-customer-loyalty")
    public void deleteTest(@PathVariable("id") Long id) {
        LOGGER.info("Deleting book with id: {}", id);
        bookService.deleteBook(id);
    }

}
