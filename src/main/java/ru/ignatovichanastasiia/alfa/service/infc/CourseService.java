
package ru.ignatovichanastasiia.alfa.service.infc;

import java.net.URL;
import javax.swing.text.Document;

/**
 *
 * @author ignatovichanastasiia
 */
public interface CourseService {
    
    URL getGif(String id);
    
    Document getJsonGif(String id);
    
}
