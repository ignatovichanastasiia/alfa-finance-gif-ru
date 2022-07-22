package ru.ignatovichanastasiia.alfa.controller;

import java.security.InvalidKeyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.ignatovichanastasiia.alfa.service.CourseServiceImpl;

/**
 *
 * @author ignatovichanastasiia
 */


@WebMvcTest(CourseController.class)
class CourseControllerTest{

    Logger logger = LogManager.getLogger(CourseControllerTest.class);
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CourseServiceImpl mockCourseService;

    @org.junit.jupiter.api.Test
    public void testGetTest() {
        logger.info("test meth. testing");
        assertTrue(true);
    }

    @org.junit.jupiter.api.Test
    public void testGetGifRedirect() throws Exception {
        logger.info("GetGifRedirect meth. testing");
        when(mockCourseService.getGif("SOS")).thenReturn("https://giphy.com/gifs/tiktok-animals-tough-tiktok-WoRz0xf3fUBWTWXUJ0");

        mockMvc.perform(MockMvcRequestBuilders.get("/course/gif/SOS"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("https://giphy.com/gifs/tiktok-animals-tough-tiktok-WoRz0xf3fUBWTWXUJ0"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }
    
    @org.junit.jupiter.api.Test
    public void testGetGifRedirect2() throws Exception {
        logger.info("GetGifRedirect meth. testing(2)");
        mockMvc.perform(MockMvcRequestBuilders.get("/course/gif/SO"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @org.junit.jupiter.api.Test
    public void testGetGifRef() throws Exception {
        logger.info("GetGifRef meth. testing");
        when(mockCourseService.getGifRef("SOS")).thenReturn("https://giphy.com/gifs/tiktok-animals-tough-tiktok-WoRz0xf3fUBWTWXUJ0");

        mockMvc.perform(MockMvcRequestBuilders.get("/course/gif/ref/SOS"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().string("https://giphy.com/gifs/tiktok-animals-tough-tiktok-WoRz0xf3fUBWTWXUJ0"));    
    }
    
    @org.junit.jupiter.api.Test
    public void testGetGifRef2() throws Exception {
        logger.info("GetGifRef meth. testing(2)");
        
        mockMvc.perform(MockMvcRequestBuilders.get("/course/gif/ref/SO"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    } 

    @org.junit.jupiter.api.Test
    public void testGetGifData() throws Exception {        
        logger.info("GetGifData meth. testing");
        when(mockCourseService.getGifData("SOS")).thenReturn("Something about gif and url: https://giphy.com/gifs/tiktok-animals-tough-tiktok-WoRz0xf3fUBWTWXUJ0");

        mockMvc.perform(MockMvcRequestBuilders.get("/course/gif/data/SOS"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().string("Something about gif and url: https://giphy.com/gifs/tiktok-animals-tough-tiktok-WoRz0xf3fUBWTWXUJ0"));
    }
    
    @org.junit.jupiter.api.Test
    public void testGetGifData2() throws Exception {
        logger.info("GetGifData meth. testing(2)");
        
        mockMvc.perform(MockMvcRequestBuilders.get("/course/gif/data/SO"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    
}
