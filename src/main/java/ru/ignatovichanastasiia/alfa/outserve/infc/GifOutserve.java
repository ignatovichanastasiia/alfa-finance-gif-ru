
package ru.ignatovichanastasiia.alfa.outserve.infc;

import ru.ignatovichanastasiia.alfa.domein.Gif;

/**
 *
 * @author ignatovichanastasiia
 */
public interface GifOutserve {
    
    String getUpOrDownGif(Boolean vector);
    
    Gif getUpOrDownJsonGif(Boolean vector);
    
}
