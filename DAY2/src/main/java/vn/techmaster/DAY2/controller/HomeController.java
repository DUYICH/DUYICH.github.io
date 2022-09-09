package vn.techmaster.DAY2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.DAY2.model.Animal;
import vn.techmaster.DAY2.model.Car;
import vn.techmaster.DAY2.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/home")

public class HomeController {
    @Autowired
    private CarRepository carRepo;
    @GetMapping
    public String home(){
        return "Home";
    }

//    @Autowired private CarRepository carRepo;
//    @GetMapping("car")
//    public ResponseEntity<List<Car>>getALLCar(){
//        return ResponseEntity.ok().body(carRepo.getAllCar());
//    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Animal> getXML(){
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("chó tây","dog"));
        animals.add(new Animal("mèo ta","cat"));
        return animals;
    }


    @RequestMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> getAllCars(){

        return carRepo.getAllCar();
    }
}




