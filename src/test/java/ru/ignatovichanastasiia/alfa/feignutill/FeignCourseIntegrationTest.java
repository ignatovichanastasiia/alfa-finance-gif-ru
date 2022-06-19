/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.ignatovichanastasiia.alfa.feignutill;

import com.github.tomakehurst.wiremock.WireMockServer;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
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
@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WireMockConfiguration.class })
public class FeignCourseIntegrationTest {
    
    @Autowired
    private WireMockServer mockRatesService;

    @Autowired
    private FeignCourseService ratesClient;

    @BeforeEach
    void setUp() throws IOException {
        CourseResponseMocks.setupMockRatesResponse(mockRatesService);
    }

    
}