
package ru.ignatovichanastasiia.alfa.controller;

import java.net.URL;
import javax.swing.text.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/gif/{id}")
    public URL getGif(@PathVariable String id){ 
        URL url = service.getGif(id);
        if(url!=null){
            return url;
        }else{
            throw new NullPointerException("gif address is null");
        }
    }
    
    @GetMapping("/json-gif/{id}")
    public Document getJsonGif(@PathVariable String id){ 
        Document gif = service.getJsonGif(id);
        if(gif!=null){
            return gif;
        }else{
            throw new NullPointerException("gif address is null");
        }
    }
    
}
