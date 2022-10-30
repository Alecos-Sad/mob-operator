package by.sadovnick.moboperator.controller.impl;

import by.sadovnick.moboperator.controller.client.RandomNumberClient;
import by.sadovnick.moboperator.controller.client.StatusClient;
import by.sadovnick.moboperator.controller.client.UUIDClient;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller to request external microservice
 */
@RestController
@RequestMapping("/status")
public class FeignApiController {

    private final StatusClient statusClient;
    private final UUIDClient uuidClient;
    private final RandomNumberClient randomNumberClient;

    public FeignApiController(StatusClient statusClient, UUIDClient uuidClient, RandomNumberClient randomNumberClient) {
        this.statusClient = statusClient;
        this.uuidClient = uuidClient;
        this.randomNumberClient = randomNumberClient;
    }

    /**
     * Get status request from external microservice
     *
     * @param status request status
     * @return request
     */
    @GetMapping("/getMessageFromMicroservice ")
    @Operation(summary = "Get message", description = "Get message from localhost:9090")
    public String getStatus(@RequestParam String status) {
        return statusClient.getStatus(status);
    }

    @GetMapping("/getUUIDFromMicroservice")
    @Operation(summary = "Get UUID", description = "Get UUID from localhost:9090")
    public UUID getUUID(){
        return uuidClient.getUUIDFromMicroservice();
    }

    @GetMapping("/getRandomNumberFromMicroservice")
    @Operation(summary = "Get random number", description = "Get random number from localhost:9090")
    public Double getRandomNumber(){
        return randomNumberClient.getRandomNumber();
    }
}
