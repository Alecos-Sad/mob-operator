package by.sadovnick.moboperator.controller.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Interface to request external microservice to get random number from 1 to 3
 */
@FeignClient(name = "getRandomNumber", url = "http://localhost:9090/number/getNumber")
public interface RandomNumberClient {

    /**
     * Getting random number from external microservice
     * @return random number from 1 to 3
     */
    @GetMapping
    Double getRandomNumber();
}
