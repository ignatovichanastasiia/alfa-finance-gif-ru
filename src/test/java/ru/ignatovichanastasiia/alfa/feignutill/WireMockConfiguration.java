
package ru.ignatovichanastasiia.alfa.feignutill;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author ignatovichanastasiia
 */

@TestConfiguration
public class WireMockConfiguration {
    
    @Autowired
    private WireMockServer wireMockServer;

    @Bean(initMethod = "start", destroyMethod = "stop")
    public WireMockServer mockRatesService() {
        return new WireMockServer(9561);
    }

}