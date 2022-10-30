package by.sadovnick.moboperator.service.impl;

import by.sadovnick.moboperator.dao.entity.Client;
import by.sadovnick.moboperator.dao.repository.ClientRepository;
import by.sadovnick.moboperator.dto.ClientDto;
import by.sadovnick.moboperator.mapper.ClientMapper;
import by.sadovnick.moboperator.service.ClientService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

/**
 * Implementation of ClientService
 * @see ClientService
 * @see ClientRepository
 * @see ClientMapper
 */
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    /**
     * Save dto to database
     * @param clientDto dto
     * @return dto
     */
    @Override
    public ClientDto save(ClientDto clientDto) {
        if (clientDto != null){
            clientRepository.save(clientMapper.clientDtoToClient(clientDto));
        } else {
            throw new EntityNotFoundException("Entity was not be null!!");
        }
        return clientDto;
    }

    /**
     * Finding client by id in database
     * @param id client id
     * @return client
     */
    @Override
    public Optional<Client> findById(Long id) {
        if (isExistById(id)){
            clientRepository.findById(id);
        } else {
            throw new EntityNotFoundException();
        }
        return clientRepository.findById(id);
    }

    /**
     * Finding all clients in database
     * @return list of clients
     */
    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    /**
     * Delete client from database by id
     * @param id client id
     */
    @Override
    public void deleteById(Long id) {
        if (isExistById(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Can't delete this ID! ID is absent");
        }
    }

    /**
     * Delete all client from database
     */
    @Override
    public void deleteAll() {
        clientRepository.deleteAll();
    }

    /**
     * Сhecks if the client with this id is in the database
     * @param id client id
     * @return boolean
     */
    public boolean isExistById(Long id) {
        return clientRepository.existsById(id);
    }

    /**
     * Finding of count of records of type Client
     * @return count of clients
     */
    public int findCount() {
        return clientRepository.findCountOfClientList();
    }
}
