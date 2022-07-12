package ru.ignatovichanastasiia.alfa.controller;

import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import ru.ignatovichanastasiia.alfa.ApplicationTest;
import ru.ignatovichanastasiia.alfa.service.CourseServiceImpl;

/**
 *
 * @author ignatovichanastasiia
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
class CourseControllerTest {

    Logger logger = LogManager.getLogger(CourseControllerTest.class);
    @Autowired
    private MockMvc mockMvc;
    @Mock
    HttpServletResponse mockHttpServletResponse;
    @Mock
    CourseServiceImpl mockCourseService;
    @InjectMocks
    CourseController mockCourseController;

    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    public CourseControllerTest() {
    }

    @org.junit.jupiter.api.Test
    public void testGetTest() {
        logger.info("test meth. testing");
        assertTrue(true);
    }

    //http://localhost:8080
    @org.junit.jupiter.api.Test
    public void testGetGif() throws Exception {
        logger.info("GetGif meth. testing");
        when(mockCourseService.getGif("SOS")).thenReturn("https://giphy.com/gifs/tiktok-animals-tough-tiktok-WoRz0xf3fUBWTWXUJ0");
        mockMvc.perform(MockMvcRequestBuilders.get("/course/gif/SOS"))
                .andExpect(status().is3xxRedirection())
                .andExpect(content().contentType("application/json"));

//            @Test
//    public void testGetExample() throws Exception {
//        List<Student> students = new ArrayList<>();
//        Student student = new Student();
//        student.setId(1);
//        student.setName("Arun");
//        students.add(student);
//        Mockito.when(studentService.getStudents()).thenReturn(students);
//        mockMvc.perform(get("/getMapping")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
//                .andExpect(jsonPath("$[0].name", Matchers.equalTo("Arun")));
//    }
    }

//    
//    @org.junit.jupiter.api.Test
//    public void testGetGif2() throws Exception {
//        HttpServletResponse mockHttpServletResponse = mock(HttpServletResponse.class);
////        CourseController mockCourseController = new CourseController();
//        CourseServiceImpl mockCourseService = mock(CourseServiceImpl.class);
//
//        logger.info("GetGif meth. testing");
//        String id = "SOS";
////        String res = "testUrlResult";
//        Mockito.doReturn("testUrlResult").when(mockCourseService.getGif(id));
////        verify(mockCourseService,times(1)).getGif(id);
////        String result = mockMvc.perform(MockMvcRequestBuilders.get("/gif/SOS"))
////                
////                .andExpect(status().isOk())
////        .andReturn(mockCourseService.getGif(id));
////        mockCourseController.getGif(id, mockHttpServletResponse);
////        assertEquals(null, result);
//    }
//    
//    //.thenThrow(new IllegalArgumentException());
//
//    @org.junit.jupiter.api.Test
//    public void testGetGifJS() throws Exception {
//        HttpServletResponse mockHttpServletResponse = spy(HttpServletResponse.class);
//        CourseController mockCourseController = spy(CourseController.class);
//        CourseServiceImpl mockCourseService = mock(CourseServiceImpl.class);
//        
//        logger.info("GetGifJS meth. testing");
//        String id = "SOS";
//        String ret = "testUrlResult";
//        Mockito.when(mockCourseService.getGifJS(id)).thenReturn(ret);
////        mockMvc.perform(MockMvcRequestBuilders.get("/gifJS/SOS"))
////                .andExpect(status().isOk());
//        String result = mockCourseController.getGifJS(id, mockHttpServletResponse);
//        assertEquals("testUrlResult", result);
//    }
//
//    @org.junit.jupiter.api.Test
//    public void testGetJsonGif() throws Exception {
//        HttpServletResponse mockHttpServletResponse = spy(HttpServletResponse.class);
//        CourseController mockCourseController = spy(CourseController.class);
//        CourseServiceImpl mockCourseService = mock(CourseServiceImpl.class);
//        
//        logger.info("GetJsonGif meth. testing");
//        String id = "SOS";
//        Mockito.when(mockCourseService.getJsonGif(id)).thenReturn("testUrlResult");
////        mockMvc.perform(MockMvcRequestBuilders.get("/json-gif/SOS"))
////                .andExpect(status().isOk());
//        String result = mockCourseController.getJsonGif(id, mockHttpServletResponse);
//        assertEquals("testUrlResult", result);
//    }
}
