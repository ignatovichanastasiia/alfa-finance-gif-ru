package ru.ignatovichanastasiia.alfa.outserve;

import javax.swing.text.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
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
@PropertySource("application.properties")
public class GifOutserveImpl implements GifOutserve {

    @Value("${gif.service.gif-api-get-url-param-q-rich}")
    String rich;
    
    @Value("${gif.service.gif-api-get-url-param-q-broke}")
    String broke;
    
    @Value("${gif.service.gif-api-get-url-path-value}")
    String urlPathValue;
    
    @Value("${gif.service.gif-app-key}")
    String appKey;
    
    @Value("${gif.service.gif-api-get-url-param-limit-int}")
    String propertyLimit;
    
    @Autowired
    FeignGifAndDocService gifservice;

    @Override
    public String getUpOrDownGif(Boolean vector) {
        System.out.println("getUpOrDownGif method");
        String q = getQ(vector);
        int limit = 1;
        int offset = getRandomOffset();
        StringBuilder bl = new StringBuilder();
        bl.append(urlPathValue);
        bl.append("?api_key");
        bl.append(appKey);
        bl.append("&q=");
        bl.append(q);
        bl.append("&limit=");
        bl.append(limit);
        bl.append("&offset=");
        bl.append(offset);
        String allPathWithParams = bl.toString();
        Gif gif = gifservice.getGif(allPathWithParams);
        String gifUrl = gif.getUrl();
        System.out.println("gifUrl= "+gifUrl);
        return gifUrl;
    }

    @Override
    public Gif getUpOrDownJsonGif(Boolean vector) {
        System.out.println("getUpOrDownJsonGif method");
        String q = getQ(vector);
        int propertyLt = Integer.valueOf(propertyLimit);
        int offset = getRandomOffset();
        StringBuilder bl = new StringBuilder();
        bl.append(urlPathValue);
        bl.append("?api_key");
        bl.append(appKey);
        bl.append("&q=");
        bl.append(q);
        bl.append("&limit=");
        bl.append(propertyLt);
        bl.append("&offset=");
        bl.append(offset);
        String allPathWithParams = bl.toString();
        Gif gif = gifservice.getGif(allPathWithParams);
        System.out.println("gif= "+gif.toString());
        return gif;
    }

    private int getRandomOffset() {
        int range = Integer.valueOf("${gif.service.gif-app-limit-offset-int}");
        return (int) (Math.random() * range);
    }
    
    private String getQ(boolean b){
        if (b) {
            return rich;
        } else {
            return broke;
        }
    }
  
}
//true = up or not changed
//false = down