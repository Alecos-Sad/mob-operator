package by.sadovnick.moboperator.service;

import by.sadovnick.moboperator.dao.entity.Client;
import by.sadovnick.moboperator.dto.ClientDto;

/**
 * Interface providing methods for working with the client service layer.
 *
 * @see MainService
 * @see MainServiceDto
 */
public interface ClientService extends MainService<Client>, MainServiceDto<ClientDto> {
    /**
     * Finding of count of records of type Client
     *
     * @return count of client
     */
    int findCount();
}
