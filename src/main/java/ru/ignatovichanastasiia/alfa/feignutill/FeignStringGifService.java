
package ru.ignatovichanastasiia.alfa.feignutill;

import org.springframework.cloud.openfeign.FeignClient;

/**
 *
 * @author ignatovichanastasiia
 */

//https://api.giphy.com/v1/gifs/search?api_key=J0DkR56nQnh5hab8zdmM0K86rafi43vB&q=broke&limit=1&offset=2
//https://api.giphy.com/v1/gifs/search?api_key=AYvKGn4IoBaKZltiQj8auY55llhbkOi7&q=rich&limit=1&offset=10

@FeignClient(value="string",url="${foreign.gif.url}",configuration = FeignStringConfiguration.class)
public interface FeignStringGifService {
    

    
}