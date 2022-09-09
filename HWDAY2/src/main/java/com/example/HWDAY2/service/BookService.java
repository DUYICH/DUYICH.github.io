package com.example.HWDAY2.service;

import com.example.HWDAY2.model.Book;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Repository
public class BookService {
    private ArrayList<Book> books = new ArrayList<>();
    public BookService(){
        try{
            File file = ResourceUtils.getFile("classpath:book.json");
            ObjectMapper mapper = new ObjectMapper();
            books.addAll(mapper.readValue(file, new TypeReference<List<Book>>() {}));
            books.forEach(System.out::println);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public List<Book> getALLBook(){
        return books;
    }
}