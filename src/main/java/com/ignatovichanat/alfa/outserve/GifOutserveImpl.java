package com.ignatovichanat.alfa.outserve;

import java.util.regex.Matcher;

import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import com.ignatovichanat.alfa.outserve.infc.GifOutserve;
import com.ignatovichanat.alfa.feignutill.FeignGifService;

/**
 *
 * @author ignatovichanat
 */

@Qualifier("GifOutserve")
@Repository
@PropertySource("application.properties")
public class GifOutserveImpl implements GifOutserve {
    
    Logger logger = LogManager.getLogger(GifOutserveImpl.class);

    @Value("${foreign.gif.path}")
    String path;

    @Value("${foreign.gif.param-q-rich}")
    String rich;

    @Value("${foreign.gif.param-q-broke}")
    String broke;

    @Value("${foreign.gif.param-limit}")
    String limit;

    @Value("${foreign.gif.param-api_key}")
    String apiKey;

    @Value("${foreign.gif.limit_offset}")
    String limitOffset;

    @Autowired
    FeignGifService gifservice;

    //https://api.giphy.com/v1/gifs/search?api_key=AYvKGn4IoBaKZltiQj8auY55llhbkOi7&q=rich&limit=1&offset=10
    //true = up or not changed
    //false = down
    @Override
    public String getUpOrDownGif(Boolean vector) throws IllegalArgumentException{
        logger.info("getUpOrDownGif method "+vector);
        String q = getQ(vector);
        int offset = getRandomOffset();
        String gif = gifservice.getGif(path, apiKey, q, limit, offset);
        String gifUrl = getUrlFromString(gif);
        return gifUrl;
    }

    @Override
    public String getUpOrDownJsonGif(Boolean vector) throws IllegalArgumentException{
        String q = getQ(vector);
        logger.info("getUpOrDownGif method "+vector);
        int offset = getRandomOffset();
        String gif = gifservice.getGif(path, apiKey, q, limit, offset);
        return gif;
    }

    private int getRandomOffset() {
        int range = Integer.valueOf(limitOffset);
        return (int) (Math.random() * range);
    }

    private String getQ(boolean b) {
        if (b) {
            return rich;
        } else {
            return broke;
        }
    }

    //"url":"https://giphy.com/gifs/SportsManias-mood-swag-money-may-cms22re9dWYKhnJbKU",
    //\"url\":\"\S+?\"
    private static String getUrlFromString(String gif) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("\"url\":\"\\S+?\"");
        Matcher matcher = pattern.matcher(gif);
        if (matcher.find()) {
            String str = matcher.group();
            String[] strArr = str.split("\"");
            return strArr[3].trim();
        }
        throw new IllegalArgumentException("Can't extract url from string(gif)!");
    }

}
