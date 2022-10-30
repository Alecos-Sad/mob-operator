package by.sadovnick.moboperator.controller;

import by.sadovnick.moboperator.dao.entity.Client;
import by.sadovnick.moboperator.dto.ClientDto;

/**
 * Provides methods for working with the client on the controller layer
 * @see MainController
 * @see MainControllerDto
 */
public interface ClientController extends MainController<Client>, MainControllerDto<ClientDto> {

    /**
     * Get count of clients
     * @return count
     */
    int getCountOfClients();
}
