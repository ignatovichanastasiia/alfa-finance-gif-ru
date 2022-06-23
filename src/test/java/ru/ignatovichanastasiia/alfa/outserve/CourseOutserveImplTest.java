package ru.ignatovichanastasiia.alfa.outserve;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.io.LineIterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;



/**
 *
 * @author ignatovichanastasiia
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
//@SpringBootTest
//@ActiveProfiles("test")
//@EnableConfigurationProperties
//@ExtendWith(SpringExtension.class)
public class CourseOutserveImplTest {

    @Test
    public void testGetCourseToThisDay() throws IOException {
        // /api/latest.json?app_id=8d7224dd749348298567a6cc1f2f9685&base=USD
        //"SDG": 456.5,
        String id = "SDG";
        CourseOutserveImpl instance = new CourseOutserveImpl();
        StringBuilder sb = new StringBuilder();
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(new File("src/test/resources/rates-response.json")))) {
            LineIterator it = new LineIterator(in);
            String line = null;
            while (it.hasNext()) {
                sb.append(line);
            }
        } catch (Exception x) {
            System.err.format("IOException: %s%n", x);
        }
            String rates = sb.toString();
            Double result = Double.valueOf(instance.getRateFromString(rates, id));
            Double expResult = 456.5;
            assertEquals(expResult, result);
        }

        @Test
        public void testGetCourseToYesterday() throws IOException {
            // api/historical/2022-06-19.json?app_id=8d7224dd749348298567a6cc1f2f9685&base=USD
            //"SYP": 2512.53,
            String id = "SYP";
            CourseOutserveImpl instance = new CourseOutserveImpl();
            StringBuilder sb = new StringBuilder();
            try ( BufferedReader reader = Files.newBufferedReader(Path.of("src/test/resources/rates-response.json"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException x) {
                System.err.format("IOException: %s%n", x);
            }
            String rates = sb.toString();
            Double result = Double.valueOf(instance.getRateFromString(rates, id));
            Double expResult = 2512.53;
            assertEquals(expResult, result);
        }

    }
