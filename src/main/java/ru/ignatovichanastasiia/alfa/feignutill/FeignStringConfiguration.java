
package ru.ignatovichanastasiia.alfa.feignutill;

import feign.Feign;
import feign.Target;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author ignatovichanastasiia
 * 
 */

@Import(FeignClientsConfiguration.class)
@Configuration
public class FeignStringConfiguration {

    String getGif(Decoder feignDecoder, Encoder feignEncoder) {
        return Feign.builder()
                .decoder(feignDecoder)
                .encoder(feignEncoder)
                .target(
                        Target.EmptyTarget.create(
                                String.class
                        )
                );
    }
}
