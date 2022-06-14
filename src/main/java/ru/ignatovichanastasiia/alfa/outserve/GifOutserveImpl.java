
package ru.ignatovichanastasiia.alfa.outserve;

import java.net.URL;
import javax.swing.text.Document;
import org.springframework.stereotype.Service;
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
        
        //parser
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public Document getUpOrDownJsonGif(Boolean vector){
        
        //just get Document and push to controller
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
