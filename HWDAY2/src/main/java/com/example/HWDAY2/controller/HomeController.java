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


    @RequestMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ArrayList<Book> getAuthorJson(){
        BookService bookService1 = new BookService();
        ArrayList<Book> bookArrayList = new ArrayList<>();
        bookArrayList = bookService.getALLBook();
    }
}
