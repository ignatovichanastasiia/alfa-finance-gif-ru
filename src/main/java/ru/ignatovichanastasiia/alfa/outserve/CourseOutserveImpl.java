
package ru.ignatovichanastasiia.alfa.outserve;

import org.springframework.stereotype.Service;
import ru.ignatovichanastasiia.alfa.outserve.infc.CourseOutserve;

/**
 *
 * @author ignatovichanastasiia
 */

@Service
public class CourseOutserveImpl implements CourseOutserve{

    //throws NullPointer
    @Override
    public Double getCourseToThisDay(String id) {
        //TODO
        return null;
    }

    //throws NullPointer
    @Override
    public Double getCourseToYesterday(String id) {
        getYesterdayDate();
        //TODO
        return null;
    }
    
    private String getYesterdayDate(){
        //TODO
        return null;
    }
    
    
    
}
