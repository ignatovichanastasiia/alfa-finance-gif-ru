
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
//https://api.giphy.com/v1/gifs/search?api_key=J0DkR56nQnh5hab8zdmM0K86rafi43vB&q=broke


@FeignClient(value="${gif.service.down-name}",url="${gif.service.down-url}")
public interface FeignGifDownService {
    
    @RequestMapping(method=RequestMethod.GET, value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> getPageOfGifs();
    
    
}

