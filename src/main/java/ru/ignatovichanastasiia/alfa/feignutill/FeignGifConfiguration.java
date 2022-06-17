
package ru.ignatovichanastasiia.alfa.feignutill;

import feign.Feign;
import feign.Target;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.ignatovichanastasiia.alfa.domein.Gif;

/**
 *
 * @author ignatovichanastasiia
 */
@Import(FeignClientsConfiguration.class)
@Configuration
public class FeignGifConfiguration {

    Gif getGif(Decoder feignDecoder, Encoder feignEncoder) {
        return Feign.builder()
                .decoder(feignDecoder)
                .encoder(feignEncoder)
                .target(
                        Target.EmptyTarget.create(
                                Gif.class
                        )
                );
    }

}
