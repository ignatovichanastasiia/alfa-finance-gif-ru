package ru.ignatovichanastasiia.alfa.outserve;

import com.github.tomakehurst.wiremock.WireMockServer;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.ignatovichanastasiia.alfa.feignutill.CourseResponseMocks;
import ru.ignatovichanastasiia.alfa.feignutill.FeignCourseService;
import ru.ignatovichanastasiia.alfa.feignutill.WireMockConfiguration;

/**
 *
 * @author ignatovichanastasiia
 */
@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WireMockConfiguration.class})
public class CourseOutserveImplTest {

    @Autowired
    private WireMockServer mockRatesService;

    @Autowired
    private FeignCourseService feign;

    public CourseOutserveImplTest() {
    }

    @Test
    public void testGetCourseToThisDay() throws IOException {
        CourseResponseMocks.setupMockRatesResponse(mockRatesService);
        // /api/latest.json?app_id=8d7224dd749348298567a6cc1f2f9685&base=USD
        //"SDG": 456.5,
        String id = "SDG";
        CourseOutserveImpl instance = new CourseOutserveImpl();
        String rates = feign.getAllCoursesToThisDay("api/latest.json", "8d7224dd749348298567a6cc1f2f9685", "USD");
        System.out.println(rates);
        String rate = instance.getRateFromString(rates, id);
        Double expResult = 456.5;
        Double result = instance.getCourseToThisDay(id);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetCourseToYesterday() throws IOException {
        CourseResponseMocks.setupMockRatesResponse2(mockRatesService);
        // api/historical/2022-06-19.json?app_id=8d7224dd749348298567a6cc1f2f9685&base=USD
        //"SYP": 2512.53,
        String id = "SYP";
        CourseOutserveImpl instance = new CourseOutserveImpl();
        String rat = feign.getAllCoursesToYesterday("api/historical/2022-06-19.json","8d7224dd749348298567a6cc1f2f9685","USD");
        String rate = instance.getRateFromString(rat,id);
        Double expResult = 2512.53;
        Double result = Double.valueOf(rate);
        assertEquals(expResult, result);

    }

}
