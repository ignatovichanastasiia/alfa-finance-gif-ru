
package ru.ignatovichanastasiia.alfa.controller;


import javax.swing.text.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ignatovichanastasiia.alfa.domein.Gif;
import ru.ignatovichanastasiia.alfa.service.infc.CourseService;

/**
 *
 * @author ignatovichanastasiia
 */

@RestController
@RequestMapping("/course")
public class CourseController {
   
    
    @Autowired
    @Qualifier("CourseService")
    private CourseService service;

    @GetMapping("/test")
    public String getTest(){
        return "Hello";
    }
    
    @GetMapping("/gif/{id}")
    public String getGif(@PathVariable String id){ 
        String url = service.getGif(id);
        if(url!=null){
            return url;
        }else{
            throw new NullPointerException("gif address is null");
        }
    }
    
    @GetMapping("/json-gif/{id}")
    public Gif getJsonGif(@PathVariable String id){ 
        Gif gif = service.getJsonGif(id);
        if(gif!=null){
            return gif;
        }else{
            throw new NullPointerException("gif is null");
        }
    }
}
