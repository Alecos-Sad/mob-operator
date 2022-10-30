package by.sadovnick.moboperator.controller.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

/**
 * Interface to request external microservice to get UUID
 */
@FeignClient(name = "getUUID", url = "http://localhost:9090/number/getUUID")
public interface UUIDClient {

    /**
     * Getting UUID from external microservice
     * @return UUID
     */
    @GetMapping()
    UUID getUUIDFromMicroservice();
}
