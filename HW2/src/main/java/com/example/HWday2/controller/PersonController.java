package com.example.HWday2.controller;

import com.example.HWday2.model.Person;
import com.example.HWday2.reposity.PersonReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class PersonController {
    @Autowired
    private PersonReposity personReposity;

    @GetMapping("/people")
    public List<Person> getPeople(){
        return  personReposity.getAll();
    }
    @GetMapping("/sortbyname")
    public List<Map.Entry<String, Long>> sortByName(){

        return personReposity.sortByName();
    }

    @GetMapping("/tangdan1")
    public List<Map.Entry<String, Long>> sortIncreaseByList(){

        return personReposity.sortIncreaseByList();
    }

    @GetMapping("/giamdan1")
    public List<Map.Entry<String, Long>> sortDecreaseByList(){

        return personReposity.sortDecreaseByList();
    }

    @GetMapping("tangdan2")
    public Map<String, Long> sortIncreaseByMap(){

        return personReposity.sortIncreaseByMap();
    }

    @GetMapping("/giamdan2")
    public Map<String, Long> sortDecreaseByMap(){

        return personReposity.sortDecreaseByMap();
    }
}
