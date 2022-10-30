package by.sadovnick.moboperator.mapper;

import by.sadovnick.moboperator.dao.entity.Client;
import by.sadovnick.moboperator.dto.ClientDto;
import org.mapstruct.*;

/**
 * An interface that converts dto into an Client and vice versa.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ClientMapper {
    /**
     * Convert dto in client
     * @param clientDto dto
     * @return client
     */
    Client clientDtoToClient(ClientDto clientDto);

    /**
     * Convert client to dto
     * @param client client
     * @return dto
     */
    ClientDto clientToClientDto(Client client);

    /**
     * Update of client from Dto
     * @param clientDto dto
     * @param client client
     * @return client
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Client updateClientFromClientDto(ClientDto clientDto, @MappingTarget Client client);
}
