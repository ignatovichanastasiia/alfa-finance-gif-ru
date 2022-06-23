package ru.ignatovichanastasiia.alfa.feignutill;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import java.io.IOException;
import static java.nio.charset.Charset.defaultCharset;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import static org.springframework.util.StreamUtils.copyToString;

/**
 *
 * @author ignatovichanastasiia
 */

public class CourseResponseMocksTD {

    public static void setupMockRatesResponseTD(WireMockServer mockService) throws IOException {
        mockService.stubFor(WireMock.get(WireMock.urlEqualTo("https://openexchangerates.org/api/latest.json?app_id=8d7224dd749348298567a6cc1f2f9685&base=USD"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(copyToString(CourseResponseMocksTD.class.getClassLoader().getResourceAsStream("rate-response.json"),
                                defaultCharset()))));
    }
}
