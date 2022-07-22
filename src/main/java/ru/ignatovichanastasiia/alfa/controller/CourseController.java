package ru.ignatovichanastasiia.alfa.controller;

import java.net.URI;
import java.security.InvalidKeyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ignatovichanastasiia.alfa.service.infc.CourseService;

/**
 *
 * @author ignatovichanastasiia
 */

@RestController
@EnableAutoConfiguration
@RequestMapping("/course")
public class CourseController {

    final Logger logger = LogManager.getLogger(CourseController.class);

    @Autowired
    @Qualifier("CourseService")
    private CourseService service;

    @GetMapping("/test")
    public String getTest() {
        logger.info("This is test debug message");
        return "Hello, you get app's test response";
    }

    @GetMapping("/gif/{id}")
    public ResponseEntity<String> getGifRedirect(@PathVariable String id) {
        try {
            if (id.matches("[a-zA-Z]{3}")) {
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(URI.create(service.getGif(id)));
                return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
            } else {
                throw new InvalidKeyException("Bad request: key must be only 3 en letter");
            }
        } catch (InvalidKeyException e) {
            logger.error("getGifJS meth. argument exc");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            logger.error("getGifJS meth. illegal exc");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/gif/ref/{id}")
    public ResponseEntity<String> getGifRef(@PathVariable String id) {
        try {
            if (id.matches("[a-zA-Z]{3}")) {
                return new ResponseEntity<>(service.getGifRef(id), HttpStatus.OK);
            } else {
                throw new InvalidKeyException("Bad request: key must be only 3 en letter");
            }
        } catch (InvalidKeyException e) {
            logger.error("getGifJS meth. argument exc");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            logger.error("getGifJS meth. illegal exc");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/gif/data/{id}")
    public ResponseEntity<String> getGifData(@PathVariable String id) {
        try {
            if (id.matches("[a-zA-Z]{3}")) {
                return new ResponseEntity<>(service.getGifData(id), HttpStatus.OK);
            } else {
                throw new InvalidKeyException("Bad request: key must be only 3 en letter");
            }
        } catch (InvalidKeyException e) {
            logger.error("getGifJS meth. argument exc");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            logger.error("getGifJS meth. illegal exc");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
