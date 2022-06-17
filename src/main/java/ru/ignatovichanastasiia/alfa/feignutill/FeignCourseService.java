
package ru.ignatovichanastasiia.alfa.feignutill;

import feign.Param;
import java.util.HashMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.PropertySource;



/**
 *
 * @author ignatovichanastasiia
 */

//Examples:
//this day course https://openexchangerates.org/api/latest.json?app_id=YOUR_APP_ID&base=USD
//y-day course https://openexchangerates.org/api/historical/2013-02-16.json?app_id=YOUR_APP_ID&base=USD
//String appId = "${course.service.url-get-path-appID}", baseCurrency = "${course.serviced.url-get-path-base-currency}"

@PropertySource("application.properties")
@FeignClient(value="${course.service.name}", url="${course.service.url}", configuration = FeignCourseConfiguration.class)
public interface FeignCourseService {
    
    @RequestMapping(method=RequestMethod.GET, 
            value = "{allPathWithParam}", consumes = "application/json")
    String getAllCoursesToThisDay(@Param ("allPathWithParam") String allPathWithParam);
    

    @RequestMapping(method=RequestMethod.GET, 
            value = "{allPathWithParams}", consumes = "application/json")
    HashMap getAllCoursesToYesterday(
        @Param ("allPathWithParams") String allPathWithParam);   

}


