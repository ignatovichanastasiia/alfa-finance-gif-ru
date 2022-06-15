
package ru.ignatovichanastasiia.alfa.feignutill;

import feign.Param;
import java.io.IOException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.cloud.openfeign.FeignClient;
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
            value=(""+"${course.service.url-get-path-latest}"+"${course.service.url-get-path-endformatter}"+"?"
            +"app_id="+"${course.service.url-get-param-appID}"+"&"+"base="+"${course.serviced.url-get-param-base-currency}"), produces = MediaType.APPLICATION_JSON_VALUE)
    Rates getAllCoursesToThisDay();
    
    
    
    @RequestMapping(method=RequestMethod.GET, 
            value=(""+"${course.service.url-get-path-historical}"), produces = MediaType.APPLICATION_JSON_VALUE)
    Rates getAllCoursesToYesterday(
        @PathVariable String datePlusFormatter, @Param("app_id") String appID, @Param ("base") String baseCurrency);   

}


