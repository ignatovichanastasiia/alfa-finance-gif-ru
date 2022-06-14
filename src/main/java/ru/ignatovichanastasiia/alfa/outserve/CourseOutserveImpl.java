
package ru.ignatovichanastasiia.alfa.outserve;

import org.springframework.stereotype.Service;
import ru.ignatovichanastasiia.alfa.outserve.infc.CourseOutserve;

/**
 *
 * @author ignatovichanastasiia
 */
//this day course https://openexchangerates.org/api/latest.json?app_id=YOUR_APP_ID&base=USD
//y-day course https://openexchangerates.org/api/historical/2013-02-16.json?app_id=YOUR_APP_ID&base=USD

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
