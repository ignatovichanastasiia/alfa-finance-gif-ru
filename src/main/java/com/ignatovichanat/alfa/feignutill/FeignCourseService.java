
package com.ignatovichanat.alfa.feignutill;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ignatovichanat
 */

//Examples:
//this day course https://openexchangerates.org/api/latest.json?app_id=YOUR_APP_ID&base=USD
//y-day course https://openexchangerates.org/api/historical/2013-02-16.json?app_id=YOUR_APP_ID&base=USD

@FeignClient(value="openexchangerates", url="${foreign.course.url}", configuration = FeignCourseConfiguration.class)
public interface FeignCourseService {
    

    @RequestMapping(method=RequestMethod.GET, 
            value = "/{path}", produces = {"Content-Type", MediaType.APPLICATION_JSON_VALUE})
    String getAllCoursesToThisDay(@PathVariable ("path") String path, @RequestParam ("app_id") String appID, @RequestParam ("base") String base);
    

    @RequestMapping(method=RequestMethod.GET, 
            value = "/{path}", produces = {"Content-Type", MediaType.APPLICATION_JSON_VALUE})
    String getAllCoursesToYesterday(@PathVariable ("path") String path, @RequestParam ("app_id") String appID, @RequestParam ("base") String base);   

}


