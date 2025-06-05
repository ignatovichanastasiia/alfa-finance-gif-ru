package com.ignatovichanat.alfa.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.ignatovichanat.alfa.outserve.infc.CourseOutserve;
import com.ignatovichanat.alfa.outserve.infc.GifOutserve;
import com.ignatovichanat.alfa.service.infc.CourseService;

/**
 *
 * @author ignatovichanat
 */

//3 letter, status 400
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
    public String getGif(String id) throws IllegalArgumentException{
        Double courseToThisDay = getCourseToThisDay(id);
        Double courseToYesterday = getCourseToYesterday(id);
        Boolean vector = false;
        if (courseToThisDay >= courseToYesterday) {
            vector = true;
        }
        return gifout.getUpOrDownGif(vector);
    }
    
    
    @Override
    public String getGifRef(String id)throws IllegalArgumentException{
        return getGif(id);
    }

    @Override
    public String getGifData(String id) throws IllegalArgumentException{
        Double courseToThisDay = getCourseToThisDay(id);
        Double courseToYesterday = getCourseToYesterday(id);
        Boolean vector = false;
        if (courseToThisDay >= courseToYesterday) {
            vector = true;
        }
        return gifout.getUpOrDownJsonGif(vector);
    }

    private Double getCourseToThisDay(String id) throws IllegalArgumentException {
        Double crs = courseout.getCourseToThisDay(id);
        if(crs==null){
            throw new NullPointerException("Double (this day course) is null");
        }
        return crs;
    }

    private Double getCourseToYesterday(String id) throws IllegalArgumentException {
        Double crsY = courseout.getCourseToYesterday(id);
        if(crsY==null){
            throw new NullPointerException("Double (yesterday course) is null");
        }
        return crsY;
    }

}
