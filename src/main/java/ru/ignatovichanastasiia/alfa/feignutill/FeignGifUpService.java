
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//
//package ru.ignatovichanastasiia.alfa.feignutill;
//
///**
// *
// * @author ignatovichanastasiia
// */
//https://api.giphy.com/v1/gifs/search?api_key=AYvKGn4IoBaKZltiQj8auY55llhbkOi7&q=rich

@FeignClient(value="${gif.service.up-name}",url="${gif.service.up-url}")
public interface FeignGifUpService {
    
    @RequestMapping(method=RequestMethod.GET, value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> getPageOfGifs();
    
}
