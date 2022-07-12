
package ru.ignatovichanastasiia.alfa.feignutill;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ignatovichanastasiia
 */

//Examples
//https://api.giphy.com/v1/gifs/search?api_key=J0DkR56nQnh5hab8zdmM0K86rafi43vB&q=broke&limit=1&offset=2
//https://api.giphy.com/v1/gifs/search?api_key=AYvKGn4IoBaKZltiQj8auY55llhbkOi7&q=rich&limit=1&offset=10

@FeignClient(value="gif",url="${foreign.gif.url}",configuration = FeignStringConfiguration.class)
public interface FeignGifService {
    
    @RequestMapping(method=RequestMethod.GET, value="/{path}", produces = {"Content-Type", MediaType.APPLICATION_JSON_VALUE})
    String getGif(@PathVariable ("path") String path, @RequestParam ("api_key") String apiKey, @RequestParam ("q") String q,@RequestParam ("limit") String limit, @RequestParam ("offset") int offset);
       
}