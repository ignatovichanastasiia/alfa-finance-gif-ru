package ru.ignatovichanastasiia.alfa.controller;

import java.net.MalformedURLException;
import java.net.URL;
import javax.servlet.http.HttpServletResponse;
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
    public String getTest() {
        return "Hello";
    }

    @GetMapping("/gif/{id}")
    public void getGif(@PathVariable String id, HttpServletResponse httpServletResponse){
        String gifUrl = service.getGif(id);
        if (gifUrl == null) {
            throw new NullPointerException("gif address is null");
        } 
        httpServletResponse.setHeader("Location", gifUrl);
        httpServletResponse.setStatus(302);
    }
    
    
    @GetMapping("/gifJS/{id}")
    public String getGifJS(@PathVariable String id){
        return service.getGifJS(id); 
    }

    @GetMapping("/json-gif/{id}")
    public String getJsonGif(@PathVariable String id) {
        String gif = service.getJsonGif(id);
        if (gif != null) {
            return gif;
        } else {
            throw new NullPointerException("gif is null");
        }
    }
}
