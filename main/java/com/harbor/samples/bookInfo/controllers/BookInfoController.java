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
public class BookInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookInfoController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private DTOUtils dtoUtils;

    @PostMapping(value = "/book", consumes = "application/json", produces = "application/json")
    public BookDTO createBook(@RequestBody BookDTO bookDto) {
        LOGGER.info("Creating book: {}", bookDto);
        Book book = dtoUtils.convertToBook(bookDto);
        LOGGER.info("Converted book: {}", book);
        return  dtoUtils.convertToBookDTO(bookService.createBook(book));
    }

    @GetMapping("/book/{id}")
    public BookDTO getBookById(@PathVariable("id") Long id) {
        LOGGER.info("Getting book with id: {}", id);
        return dtoUtils.convertToBookDTO(bookService.getBookById(id));
    }

    @PutMapping(value = "/book/{id}", consumes = "application/json", produces = "application/json")
    public BookDTO updateBook(@PathVariable("id") Long id, @RequestBody BookDTO bookDto) {
        LOGGER.info("Updating book: {}", bookDto);
        Book book = dtoUtils.convertToBook(bookDto);
        LOGGER.info("Converted book: {}", book);
        return dtoUtils.convertToBookDTO(bookService.updateBook(book));
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        LOGGER.info("Deleting book with id: {}", id);
        bookService.deleteBook(id);
    }

    @GetMapping("/getBookByName")
    public List<BookDTO> getBookByName(@RequestParam("bookName") String name) {
        LOGGER.info("Getting book with name: {}", name);
        return bookService.getBookByName(name);
    }

}
