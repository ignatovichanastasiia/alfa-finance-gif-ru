
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

    @Override
    public Gif getUpOrDownGif(Boolean vector) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
