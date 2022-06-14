
package ru.ignatovichanastasiia.alfa.feignutill;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.cloud.openfeign.FeignClient;


/**
 *
 * @author ignatovichanastasiia
 */

@FeignClient(value="${course.service.name}", url="${course.service.url}")
public interface FeignCourseService {
    
    @RequestMapping(method=RequestMethod.GET, value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> getAllCourses();
    
    
    
}



