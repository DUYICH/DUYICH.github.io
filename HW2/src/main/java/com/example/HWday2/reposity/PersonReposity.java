package com.example.HWday2.reposity;

import com.example.HWday2.model.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PersonReposity {
    private ArrayList<Person> persons = new ArrayList<>();
    public PersonReposity(){
        try{
            File file = ResourceUtils.getFile("classpath:static/Person.json");
            ObjectMapper mapper = new ObjectMapper();
            persons.addAll(mapper.readValue(file, new TypeReference<List<Person>>(){}));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public List<Person> getAll(){
        return persons;
    }
    // đếm số lượng quốc tịch
    public Map<String, Long> countByNationality(){
        return persons
                .stream()
                .collect(Collectors.groupingBy(Person::getNationality, Collectors.counting()));
    }
    // sắp xếp theo tên quốc tịch
    public List<Map.Entry<String, Long>> sortByName(){
        return persons
                .stream()
                .collect(Collectors.groupingBy(Person::getNationality, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .collect(Collectors.toList());
    }
    //sắp xếp tăng dần theo list
    public List<Map.Entry<String, Long>> sortDecreaseByList() {
        return persons
                .stream()
                .collect(Collectors.groupingBy(Person::getNationality, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }
    // giảm dần theo list
    public List<Map.Entry<String, Long>> sortIncreaseByList() {
        return persons
                .stream()
                .collect(Collectors.groupingBy(Person::getNationality, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }
    //tăng dần theo map
    public Map<String, Long> sortIncreaseByMap() {
        return persons
                .stream()
                .collect(Collectors.groupingBy(Person::getNationality, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));
    }
    //giảm dần theo map
    public Map<String, Long> sortDecreaseByMap() {
        return persons
                .stream()
                .collect(Collectors.groupingBy(Person::getNationality, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));
    }
}
