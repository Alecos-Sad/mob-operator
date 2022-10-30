package by.sadovnick.moboperator.service;

import by.sadovnick.moboperator.dao.entity.Client;
import by.sadovnick.moboperator.dao.repository.ClientRepository;
import by.sadovnick.moboperator.dto.ClientDto;
import by.sadovnick.moboperator.exception.NotCorrectException;
import by.sadovnick.moboperator.mapper.ClientMapper;
import by.sadovnick.moboperator.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @Mock
    private ClientMapper clientMapper;
    @Mock
    private ClientRepository clientRepository;
    @InjectMocks
    private ClientServiceImpl clientService;
    private static Client client = new Client();
    private static ClientDto clientDto = new ClientDto();

    @BeforeEach
    public void init(){
        client.setId(1L);
        client.setName("Alex");
        client.setSurName("SadovNickOFF");

        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setSurName(client.getSurName());

        List<Client> clients = new ArrayList<>();
        List<ClientDto> clientsDto = new ArrayList<>();

        clients.add(client);
        clientsDto.add(clientDto);
    }


    @Test
    @DisplayName("test save method")
    public void saveTest(){
        when(clientMapper
                .clientDtoToClient(ArgumentMatchers.any(ClientDto.class)))
                .thenReturn(client);
        when(clientRepository.save(ArgumentMatchers.any(Client.class))).thenReturn(client);
        assertEquals(clientDto, clientService.save(clientDto));
    }

    @Test
    @DisplayName("test save exception")
    public void saveException(){
        when(clientMapper
                .clientDtoToClient(ArgumentMatchers.any(ClientDto.class)))
                .thenReturn(null);
        when(clientRepository.save(ArgumentMatchers.any(Client.class))).thenReturn(client);
        Throwable exception = assertThrows(EntityNotFoundException.class,()->{
           clientService.save(clientDto);
        });
        assertAll(() -> {
            assertEquals("Entity was not be null!!",exception.getMessage());
        });
    }

}
