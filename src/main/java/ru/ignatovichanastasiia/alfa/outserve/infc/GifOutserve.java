
package ru.ignatovichanastasiia.alfa.outserve.infc;

import java.net.URL;
import javax.swing.text.Document;

/**
 *
 * @author ignatovichanastasiia
 */
public interface GifOutserve {
    
    URL getUpOrDownGif(Boolean vector);
    
    Document getUpOrDownJsonGif(Boolean vector);
    
}
