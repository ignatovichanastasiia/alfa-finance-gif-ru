package ru.ignatovichanastasiia.alfa.service;

import java.net.URL;
import javax.swing.text.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.ignatovichanastasiia.alfa.outserve.infc.CourseOutserve;
import ru.ignatovichanastasiia.alfa.outserve.infc.GifOutserve;
import ru.ignatovichanastasiia.alfa.service.infc.CourseService;

/**
 *
 * @author ignatovichanastasiia
 */
@Qualifier("CourseService")
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    @Qualifier("CourseOutserve")
    private CourseOutserve courseout;
    @Autowired
    @Qualifier("GifOutserve")
    private GifOutserve gifout;
 
        

    @Override
    public URL getGif(String id) {
        Double courseToThisDay = getCourseToThisDay(id);
        Double courseToYesterday = getCourseToYesterday(id);

        Boolean vector = false;
        if (courseToThisDay >= courseToYesterday) {
            vector = true;
        }
        return gifout.getUpOrDownGif(vector);
    }

    @Override
    public Document getJsonGif(String id) {
        Double courseToThisDay = getCourseToThisDay(id);
        Double courseToYesterday = getCourseToYesterday(id);
        if (courseToThisDay != null && courseToYesterday != null) {
            Boolean vector = false;
            if (courseToThisDay >= courseToYesterday) {
                vector = true;
            }
            return gifout.getUpOrDownJsonGif(vector);
        } else {
            throw new NullPointerException("One of courses is null");
        }
    }

    private Double getCourseToThisDay(String id) {
        return courseout.getCourseToThisDay(id);
    }

    private Double getCourseToYesterday(String id) {
        return courseout.getCourseToYesterday(id);
    }


}
