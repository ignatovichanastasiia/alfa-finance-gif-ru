
package ru.ignatovichanastasiia.alfa.feignutill;

import feign.Param;
import java.io.IOException;
import javax.swing.text.Document;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ignatovichanastasiia.alfa.domein.Gif;

//
///**
// *
// * @author ignatovichanastasiia
// */

//Examples
//https://api.giphy.com/v1/gifs/search?api_key=J0DkR56nQnh5hab8zdmM0K86rafi43vB&q=broke&limit=1&offset=2
//https://api.giphy.com/v1/gifs/search?api_key=AYvKGn4IoBaKZltiQj8auY55llhbkOi7&q=rich&limit=1&offset=10


@FeignClient(value="${gif.service.name}",url="${gif.service.gif-api-url}")
public interface FeignGifAndDocService {
    
    @RequestMapping(method=RequestMethod.GET, value="${gif.service.gif-api-get-url-path-value}", produces = MediaType.APPLICATION_JSON_VALUE)
    Document getPageOfGif(@Param ("api_key") String apiKey, @Param ("q") String q, @Param ("limit") int limit, @Param ("offset") int offset);
    
    @RequestMapping(method=RequestMethod.GET, value="${gif.service.gif-api-get-url-path-value}", produces = MediaType.APPLICATION_JSON_VALUE)
    Gif getGif(@Param ("api_key") String apiKey, @Param ("q") String q, @Param ("limit") int limit, @Param ("offset") int offset);
    
}