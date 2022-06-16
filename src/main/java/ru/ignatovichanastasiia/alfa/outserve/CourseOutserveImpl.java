package ru.ignatovichanastasiia.alfa.outserve;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.ignatovichanastasiia.alfa.domein.Rates;
import ru.ignatovichanastasiia.alfa.feignutill.FeignCourseService;
import ru.ignatovichanastasiia.alfa.outserve.infc.CourseOutserve;

/**
 *
 * @author ignatovichanastasiia
 */
//examples
//this day course https://openexchangerates.org/api/latest.json?app_id=YOUR_APP_ID&base=USD
//y-day course https://openexchangerates.org/api/historical/2013-02-16.json?app_id=YOUR_APP_ID&base=USD

@Qualifier("CourseOutserve")
@Repository
public class CourseOutserveImpl implements CourseOutserve {
    
    @Autowired
    FeignCourseService courseService;
    
    @Override
    public Double getCourseToThisDay(String id) {
        String pathPlusParams = "${course.service.url-get-path-with-all-param-latest}";
        Rates rates = courseService.getAllCoursesToThisDay(pathPlusParams);
        String strCourseId = rates.getAllCourses().get(id).toString();
        try{
        Double courseId = Double.valueOf(strCourseId);
        return courseId;
        }catch(ClassCastException ex){
            ex.printStackTrace();
            throw new NullPointerException("There is no course to this day");
        }
        
    }

    @Override
    public Double getCourseToYesterday(String id) {
        String pathPlusParamsYesterday = "${course.service.url-get-path-api-historical}"+getYesterdayDate()+".json"+"?app_id="+"${course.service.url-get-param-appID}"+"&base="+"${course.serviced.url-get-param-base-currency}";
        Rates rat = courseService.getAllCoursesToYesterday(pathPlusParamsYesterday);
        String strCourseId = rat.getAllCourses().get(id).toString();
        try{
        Double courseId = Double.valueOf(strCourseId);
        return courseId;
        }catch(ClassCastException ex){
            ex.printStackTrace();
            throw new NullPointerException("There is no course to this yesterday");
        }
    }

    private String getYesterdayDate() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(cal.getTime());
    }

}
