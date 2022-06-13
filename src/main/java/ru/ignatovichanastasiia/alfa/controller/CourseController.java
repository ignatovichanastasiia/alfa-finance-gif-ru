
package ru.ignatovichanastasiia.alfa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ignatovichanastasiia.alfa.domein.Gif;
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
    public ResponseEntity<Object> getInformation(@PathVariable String id){ 
        Gif gif = service.getInformation(id);
        if(gif!=null){
            return gif;
        }else{
            throw new NullPointerException("gif address is null");
        }
    }
    
}
