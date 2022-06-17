package ru.ignatovichanastasiia.alfa.outserve;

import com.google.gson.Gson;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.ignatovichanastasiia.alfa.feignutill.FeignCourseService;
import ru.ignatovichanastasiia.alfa.outserve.infc.CourseOutserve;

/**
 *
 * @author ignatovichanastasiia
 */
//examples
//this day course https://openexchangerates.org/api/latest.json?app_id=8d7224dd749348298567a6cc1f2f9685&base=USD
//y-day course https://openexchangerates.org/api/historical/2013-02-16.json?app_id=8d7224dd749348298567a6cc1f2f9685&base=USD

@Qualifier("CourseOutserve")
@Repository
@PropertySource("application.properties")
public class CourseOutserveImpl implements CourseOutserve {
    final Gson gson = new Gson();
    
    @Value("${course.service.url-get-path-with-all-param-latest}")
    String allPathWithParams;
    
    @Value("${course.service.url-get-path-api-historical}")
    String historical;
    
    @Value("${course.service.url-get-path-api-historical}")
    String appId;
    
    @Value("${course.serviced.url-get-param-base-currency}")
    String baseCurrency;
            
    @Autowired
    FeignCourseService courseService;
    
    @Override
    public Double getCourseToThisDay(String id) {
        System.out.println("getCourseToThisDay method");
        System.out.println(allPathWithParams);
        String rates = courseService.getAllCoursesToThisDay(allPathWithParams);
        System.out.println("rates= "+rates);
//        try{
//            String strCourseId = rates.get(id).toString();
//            Double courseId = Double.valueOf(strCourseId);
//            return courseId;
//        }catch(ClassCastException ex){
//            ex.printStackTrace();
//            throw new NullPointerException("There is no course to this day");
//        }
        return null;
    }

    @Override
    public Double getCourseToYesterday(String id) {
        System.out.println("getCourseToYesterday");
        StringBuilder bl = new StringBuilder();
        bl.append(historical);
        bl.append(getYesterdayDate());
        bl.append(".json");
        bl.append("?app_id=");
        bl.append(appId);
        bl.append("&base=");
        bl.append(baseCurrency);
        String pathPlusParamsYesterday = bl.toString();
        Map rat = courseService.getAllCoursesToYesterday(pathPlusParamsYesterday);
        System.out.println("rat= "+rat.toString());
        try{
            String strCourseId = rat.get(id).toString();
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
