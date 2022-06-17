
package ru.ignatovichanastasiia.alfa.feignutill;

import feign.Param;
import javax.swing.text.Document;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.PropertySource;
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


@PropertySource("application.properties")
@FeignClient(value="${gif.service.name}",url="${gif.service.gif-api-url}",configuration = FeignGifConfiguration.class)
public interface FeignGifAndDocService {
    
    @RequestMapping(method=RequestMethod.GET, value="{allPathWithParams}", produces = MediaType.APPLICATION_JSON_VALUE)
    Document getPageOfGif(@Param ("allPathWithParams") String allPathWithParam);
    
    @RequestMapping(method=RequestMethod.GET, value="{allPathWithParams}", produces = MediaType.APPLICATION_JSON_VALUE)
    Gif getGif(@Param ("allPathWithParams") String allPathWithParam);
    
}