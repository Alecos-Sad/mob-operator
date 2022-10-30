package by.sadovnick.moboperator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Сonfiguration class.
 */
@Configuration
public class AppConfig {

    /**
     * Bean for Class RestTemplate
     * @return Class to provide Http requests based on the Rest specification
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
