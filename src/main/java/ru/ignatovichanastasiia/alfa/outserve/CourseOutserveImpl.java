package ru.ignatovichanastasiia.alfa.outserve;

import com.google.gson.Gson;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
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

    @Value("${foreign.course.path-latest}")
    String pathForLates;
    
    @Value("${foreign.course.path-historical}")
    String historical;
    
    @Value("${foreign.course.parh-endformatter}")
    String endJson;
    
    @Value("${foreign.course.param-app_id}")
    String appID;
    
    @Value("${foreign.course.param-base}")
    String base;

    @Autowired
    FeignCourseService courseService;
   

    @Override
    public Double getCourseToThisDay(String id) throws IllegalArgumentException{
        System.out.println("getCourseToThisDay method");
        System.out.println("path = " + pathForLates);
        String rates = courseService.getAllCoursesToThisDay(pathForLates,appID,base);
        String rate = getRateFromString(rates,id);
        return Double.valueOf(rate);
    }

    @Override
    public Double getCourseToYesterday(String id) {
        System.out.println("getCourseToYesterday");
        StringBuilder bl = new StringBuilder();
        bl.append(historical);
        bl.append(getYesterdayDate());
        bl.append(".json");
        String pathYesterday = bl.toString();
        System.out.println(pathYesterday);
        String rat = courseService.getAllCoursesToYesterday(pathYesterday,appID,base);
        String rate = getRateFromString(rat,id);
        return Double.valueOf(rate);
    }

    private String getYesterdayDate() {
        LocalDate td = LocalDate.now();
        LocalDate yd = td.plusDays(-1);
        System.out.println(yd);
        return yd.toString();
    }

    //"AED": 3.6731,
    //[\"]AED[\"][:]\\s\\d{1,}[.]\\d{1,}

    public String getRateFromString(String stringRates, String id) throws IllegalArgumentException{
        StringBuilder sb = new StringBuilder();
        sb.append("[\"]");
        sb.append(id);
        sb.append("[\"][:]\\s\\d{1,}[.]\\d{1,}");
        Pattern pattern = Pattern.compile(sb.toString());
        Matcher matcher = pattern.matcher(stringRates);
        if(matcher.find()){
            String str = matcher.group();
            String[] strArr = str.split(":");
            return strArr[1].trim();
        }
        throw new IllegalArgumentException("Can't extract course of "+id+" from string!");
    }
    
}
