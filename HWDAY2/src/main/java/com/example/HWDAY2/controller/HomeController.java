package com.example.HWDAY2.controller;

import com.example.HWDAY2.model.Book;
import com.example.HWDAY2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Controller
@RestController
@RequestMapping(value = "/home")
public class HomeController {
    @GetMapping(value = "/home", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String Home(){
        return "Home";
    }
    @Autowired
    private BookService bookService;
    @GetMapping
    public String home(){
        return "Home";
    }

    @RequestMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getALLBook(){
        return bookService.getALLBook();
    }

    @RequestMapping(value = "/year", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBookYear(){
        List<Book> bookArrayList = new ArrayList<>();
        bookArrayList = bookService.getALLBook();
        Collections.sort(bookArrayList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if(o1.getYear() < o2.getYear())
                    return 1;
                else if (o1.getYear() > o2.getYear())
                    return -1;
                return 0;
            }
        });
        return bookArrayList;
    }

    @RequestMapping(value = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBookId(){
        List<Book> bookArrayList = new ArrayList<>();
        bookArrayList = bookService.getALLBook();
        Collections.sort(bookArrayList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if(o1.getId() < o2.getId())
                    return 1;
                else if (o1.getId() > o2.getId())
                    return -1;
                return 0;
            }
        });
        return bookArrayList;
    }
    @RequestMapping(value = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBookAuthor(){
        List<Book> bookArrayList = new ArrayList<>();
        bookArrayList = bookService.getALLBook();
        Collections.sort(bookArrayList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthor().compareTo(o2.getAuthor());
            }
        });
        return bookArrayList;
    }
}
