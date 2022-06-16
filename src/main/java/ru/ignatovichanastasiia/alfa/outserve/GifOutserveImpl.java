package ru.ignatovichanastasiia.alfa.outserve;

import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.text.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.ignatovichanastasiia.alfa.domein.Gif;
import ru.ignatovichanastasiia.alfa.feignutill.FeignGifAndDocService;
import ru.ignatovichanastasiia.alfa.outserve.infc.GifOutserve;

/**
 *
 * @author ignatovichanastasiia
 */

@Qualifier("GifOutserve")
@Repository
public class GifOutserveImpl implements GifOutserve {

    @Autowired
    FeignGifAndDocService gifservice;

//    https://api.giphy.com/v1/gifs/search?api_key=J0DkR56nQnh5hab8zdmM0K86rafi43vB&q=broke&limit=1&offset=2
    @Override
    public URL getUpOrDownGif(Boolean vector) {
        String rich = "${gif.service.gif-api-get-url-param-q-rich}";
        String broke = "${gif.service.gif-api-get-url-param-q-broke}";
        String q;
        if (vector) {
            q = rich;
        } else {
            q = broke;
        }
        int limit = 1;
        int offset = getRandomOffset();
        String allPathWithParams = "${gif.service.gif-api-get-url-path-value}"+"?api_key"+"${gif.service.gif-app-key}"+"&q="+q+"&limit="+limit+"&offset="+offset;
        Gif gif = gifservice.getGif(allPathWithParams);
        if (gif != null) {
            try {
                URL gifUrl = new URL(gif.getUrl());
                return gifUrl;
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
                throw new NullPointerException("There is no correct URL of GIF");
            }
        } else {
            throw new NullPointerException("There is no GIF");
        }

    }

    @Override
    public Document getUpOrDownJsonGif(Boolean vector) {
        String rich = "${gif.service.gif-api-get-url-param-q-rich}";
        String broke = "${gif.service.gif-api-get-url-param-q-broke}";
        String q;
        if (vector) {
            q = rich;
        } else {
            q = broke;
        }
        int limit = Integer.valueOf("${gif.service.gif-api-get-url-param-limit-int}");
        int offset = getRandomOffset();
        String allPathWithParams = "${gif.service.gif-api-get-url-path-value}"+"?api_key"+"${gif.service.gif-app-key}"+"&q="+q+"&limit="+limit+"&offset="+offset;
        return gifservice.getPageOfGif(allPathWithParams);
    }

    private int getRandomOffset() {
        int range = Integer.valueOf("${gif.service.gif-app-limit-offset-int}");
        return (int) (Math.random() * range);
    }
  
}
//true = up or not changed
//false = down