package by.sadovnick.moboperator.mapper;

import by.sadovnick.moboperator.dao.entity.Tariff;
import by.sadovnick.moboperator.dto.TariffDto;
import org.mapstruct.*;

/**
 * An interface that converts dto into an Tariff and vice versa.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TariffMapper {
    /**
     * Convert dto in tariff
     * @param tariffDto dto
     * @return tariff
     */
    Tariff tariffDtoToTariff(TariffDto tariffDto);

    /**
     * Convert tariff in dto
     * @param tariff tariff
     * @return dto
     */
    TariffDto tariffToTariffDto(Tariff tariff);

    /**
     * Update of client from dto
     * @param tariffDto dto
     * @param tariff tariff
     * @return tariff
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Tariff updateTariffFromTariffDto(TariffDto tariffDto, @MappingTarget Tariff tariff);
}
