package com.agan.book.controller;

import com.agan.book.pojo.Book;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("book")
public class BookController {

    private Book book;

    @PostMapping
    public String processBook(@RequestBody Book book) {
        this.book = book;
        return "success";
    }

    @GetMapping
    public Book book() {
        return this.book;
    }

}
