
package ru.ignatovichanastasiia.alfa.outserve;

import org.springframework.stereotype.Service;
import ru.ignatovichanastasiia.alfa.domein.Gif;
import ru.ignatovichanastasiia.alfa.outserve.infc.GifOutserve;

/**
 *
 * @author ignatovichanastasiia
 */

@Service
public class GifOutserveImpl implements GifOutserve{
//true = up or not changed
//false = down
    //throws NullPointer
    @Override
    public Gif getGif(Boolean vector) {
        //TODO 
        
        return null;
    }
    
    
}
