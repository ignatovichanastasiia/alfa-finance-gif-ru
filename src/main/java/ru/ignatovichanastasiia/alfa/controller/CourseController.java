
package ru.ignatovichanastasiia.alfa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ignatovichanastasiia.alfa.service.CourseServiceImpl;

/**
 *
 * @author ignatovichanastasiia
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    
    @Autowired
    private CourseServiceImpl service;
    
    @GetMapping("/{id}")
    public ResponseEntity getInformation(String id){ //вставить id значение из гет запроса
        String gifAddress = service.getInformation(id);
        //TODO 
        return null;
    }
    
}
