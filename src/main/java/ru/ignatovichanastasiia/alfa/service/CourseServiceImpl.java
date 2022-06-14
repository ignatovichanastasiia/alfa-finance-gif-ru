
package ru.ignatovichanastasiia.alfa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ignatovichanastasiia.alfa.controller.CourseController;
import ru.ignatovichanastasiia.alfa.domein.Gif;
import ru.ignatovichanastasiia.alfa.outserve.CourseOutserveImpl;
import ru.ignatovichanastasiia.alfa.outserve.GifOutserveImpl;
import ru.ignatovichanastasiia.alfa.service.infc.CourseService;

/**
 *
 * @author ignatovichanastasiia
 */
@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseController controller;
    @Autowired
    private CourseOutserveImpl courseout;
    @Autowired
    private GifOutserveImpl gifout;

    @Override
    public Gif getGif(String id){
        Double courseToThisDay = getCourseToThisDay(id);
        Double courseToYesterday = getCourseToYesterday(id);
        Boolean vector = false;
        if(courseToThisDay>=courseToYesterday){
            vector = true;
        }
        return gifout.getUpOrDownGif(vector);
    }
    
    private Double getCourseToThisDay(String id){
        return courseout.getCourseToThisDay(id);
    }
    
    private Double getCourseToYesterday(String id){
        return courseout.getCourseToYesterday(id);
    }

}
