package by.sadovnick.moboperator.controller.impl;

import by.sadovnick.moboperator.controller.ClientController;
import by.sadovnick.moboperator.dao.entity.Client;
import by.sadovnick.moboperator.dto.ClientDto;
import by.sadovnick.moboperator.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Implementation of {@link ClientController}
 * @see ClientService
 */
@RestController
@RequestMapping(value = "/client")
@Tag(name = "Clients", description = "To work with clients")
public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;

    public ClientControllerImpl(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Save client dto to database
     * @param clientDto dto
     */
    @Override
    @PostMapping("/save")
    @Operation(summary = "Save client", description = "Save client to database")
    public void save(@RequestBody ClientDto clientDto) {
        clientService.save(clientDto);
    }

    /**
     * Get client from database by id
     * @param id client id
     * @return client
     */
    @Override
    @GetMapping("/getByID")
    @Operation(summary = "Get client by ID", description = "Get client from database by ID")
    public Optional<Client> getById(@RequestParam Long id) {
        return clientService.findById(id);
    }

    /**
     * Get all clients from database
     * @return list of clients
     */
    @Override
    @GetMapping("/getAll")
    @Operation(summary = "Get all clients", description = "Get all clients from database")
    public Iterable<Client> getAll() {
        return clientService.findAll();
    }

    /**
     * Delete client by id from database
     * @param id client id
     */
    @Override
    @DeleteMapping("/deleteByID")
    @Operation(summary = "Delete client by ID", description = "Delete client from database by ID")
    public void deleteById(@RequestParam Long id) {
        clientService.deleteById(id);
    }

    /**
     * Delete all clients from database
     */
    @Override
    @DeleteMapping("/deleteAll")
    @Operation(summary = "Delete all", description = "Delete clients from database")
    public void deleteAll() {
        clientService.deleteAll();
    }


    @Override
    @GetMapping("/getCount")
    @Operation(summary = "Count of client", description = "Show how many clients in total")
    public int getCountOfClients() {
        return clientService.findCount();
    }
}
