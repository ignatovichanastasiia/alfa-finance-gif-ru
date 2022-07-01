package ru.ignatovichanastasiia.alfa.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public String getTest() {
        return "Hello";
    }

    @GetMapping("/gif/{id}")
    public void getGif(@PathVariable String id, HttpServletResponse httpServletResponse){
        try{
            String gifUrl = service.getGif(id); 
            httpServletResponse.setHeader("Location", gifUrl);
            httpServletResponse.setStatus(302);
        }catch(IllegalArgumentException e){
            e.printStackTrace();
            httpServletResponse.setStatus(404);
        }
    }
    
    @GetMapping("/gifJS/{id}")
    public String getGifJS(@PathVariable String id, HttpServletResponse httpServletResponse){
        try{
            return service.getGifJS(id);
            }catch(IllegalArgumentException e){
            e.printStackTrace();
            httpServletResponse.setStatus(404);
            return null;
            } 
    }

    @GetMapping("/json-gif/{id}")
    public String getJsonGif(@PathVariable String id, HttpServletResponse httpServletResponse) {
        try{
            return service.getJsonGif(id);
        }catch(IllegalArgumentException e){
            e.printStackTrace();
            httpServletResponse.setStatus(404);
            return null;
        } 
    }
}

