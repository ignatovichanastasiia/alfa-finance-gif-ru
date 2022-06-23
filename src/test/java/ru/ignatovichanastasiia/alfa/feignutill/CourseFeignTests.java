
package ru.ignatovichanastasiia.alfa.feignutill;

import com.github.tomakehurst.wiremock.WireMockServer;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 *
 * @author ignatovichanastasiia
 */

//@SpringBootTest
//@ActiveProfiles("test")
//@EnableConfigurationProperties
//@ExtendWith(SpringExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = { WireMockConfiguration.class })
public class CourseFeignTests {
    
    @Autowired
    private WireMockServer mockRatesService;

    @Autowired
    private FeignCourseService feign;

//    @BeforeEach
//    void setUp() throws IOException {
//        CourseResponseMocksTD.setupMockRatesResponse(mockRatesService);
//    }

    @Test
    public void testGetCourseToThisDay() throws IOException {
        CourseResponseMocksTD.setupMockRatesResponseTD(mockRatesService);
        // /api/latest.json?app_id=8d7224dd749348298567a6cc1f2f9685&base=USD
        String result = feign.getAllCoursesToThisDay("api/latest.json", "8d7224dd749348298567a6cc1f2f9685", "USD");
        System.out.println(result);
        String expResult = "{\"SOS\": \"578.826574\"}";
        assertEquals(expResult, result);

    }

//    @Test
//    public void testGetCourseToYesterday() throws IOException {
//        CourseResponseMocksYD.setupMockRatesResponseYD(mockRatesService);
//        // api/historical/2022-06-19.json?app_id=8d7224dd749348298567a6cc1f2f9685&base=USD
//        //"SYP": 2512.53,
//        String id = "SYP";
//        CourseOutserveImpl instance = new CourseOutserveImpl();
//        String rat = feign.getAllCoursesToYesterday("api/historical/2022-06-19.json","8d7224dd749348298567a6cc1f2f9685","USD");
//        String rate = instance.getRateFromString(rat,id);
//        Double expResult = 2512.53;
//        Double result = Double.valueOf(rate);
//        assertEquals(expResult, result);
//
//    }

}