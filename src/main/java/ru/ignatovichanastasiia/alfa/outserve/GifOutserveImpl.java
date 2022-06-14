
package ru.ignatovichanastasiia.alfa.outserve;

import java.net.URL;
import javax.swing.text.Document;
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
    public URL getUpOrDownGif(Boolean vector) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public Document getUpOrDownJsonGif(Boolean vector){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
