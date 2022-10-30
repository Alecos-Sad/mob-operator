package by.sadovnick.moboperator.controller.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interface to request external microservice to get message
 */
@FeignClient(name = "getStatus", url = "http://localhost:9090/number/getStatus")
public interface StatusClient {

    /**
     * Getting status from external microservice
     * @param status status request
     * @return request
     */
    @GetMapping()
    String getStatus(@RequestParam String status);
}
