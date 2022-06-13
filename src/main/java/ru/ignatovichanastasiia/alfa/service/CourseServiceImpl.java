
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

    //получаем string с адресом гифки
    @Override
    public Gif getInformation(String id){
        Double courseToThisDay = getCourseToThisDay(id);
        Double courseToYesterday = getCourseToYesterday(id);
        Boolean vector = false;
        if(courseToThisDay>=courseToYesterday){
            vector = true;
        }
        return getGif(vector);
    }
    
    //метод, посылающий запрос на out курсов (получаем курс на —≈√ќƒЌя)
    private Double getCourseToThisDay(String id){
        return courseout.getCourseToThisDay(id);
    }
    
    //метод, посылающий запрос на out курсов (получаем курс за ¬„≈–ј)
    private Double getCourseToYesterday(String id){
        return courseout.getCourseToYesterday(id);
    }
    
    //метод, посылающий запрос на out гифок
    private Gif getGif(Boolean vector){
        return gifout.getGif(vector);
    }

}
