
package ru.ignatovichanastasiia.alfa.service.infc;



import ru.ignatovichanastasiia.alfa.domein.Gif;

/**
 *
 * @author ignatovichanastasiia
 */
public interface CourseService {
    
    String getGif(String id);
    
    Gif getJsonGif(String id);
    
}
