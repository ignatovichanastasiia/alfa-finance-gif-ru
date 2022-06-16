
package ru.ignatovichanastasiia.alfa.feignutill;

import feign.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import ru.ignatovichanastasiia.alfa.domein.Rates;


/**
 *
 * @author ignatovichanastasiia
 */

//Examples:
//this day course https://openexchangerates.org/api/latest.json?app_id=YOUR_APP_ID&base=USD
//y-day course https://openexchangerates.org/api/historical/2013-02-16.json?app_id=YOUR_APP_ID&base=USD
//String appId = "${course.service.url-get-path-appID}", baseCurrency = "${course.serviced.url-get-path-base-currency}"


@FeignClient(value="${course.service.name}", url="${course.service.url}")
public interface FeignCourseService {
    
    @RequestMapping(method=RequestMethod.GET, 
            value=("{allPathWithParam}"), produces = MediaType.APPLICATION_JSON_VALUE)
    Rates getAllCoursesToThisDay(@Param ("allPathWithParam") String allPathWithParam);
    
    
    @RequestMapping(method=RequestMethod.GET, 
            value=("{allPathWithParams}"), produces = MediaType.APPLICATION_JSON_VALUE)
    Rates getAllCoursesToYesterday(
        @Param ("allPathWithParams") String allPathWithParam);   

}


