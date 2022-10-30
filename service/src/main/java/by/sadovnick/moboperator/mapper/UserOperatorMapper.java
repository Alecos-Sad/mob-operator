package by.sadovnick.moboperator.mapper;

import by.sadovnick.moboperator.dao.entity.Tariff;
import by.sadovnick.moboperator.dao.entity.UserOperator;
import by.sadovnick.moboperator.dto.UserOperatorDto;
import org.mapstruct.*;

/**
 * An interface that converts dto into an User operator and vice versa.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserOperatorMapper {

    /**
     * Convert dto in User operator
     * @param userOperatorDto dto
     * @return user operator
     */
    UserOperator userOperatorDtoToUserOperator(UserOperatorDto userOperatorDto);

    /**
     * Convert user operator to dto
     * @param userOperator user operator
     * @return dto
     */
    UserOperatorDto userOperatorToUserOperatorDto(UserOperator userOperator);

    /**
     * Update user operator from dto
     * @param userOperatorDto dto
     * @param userOperator user operator
     * @return user operator
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserOperator updateUserOperatorFromUserOperatorDto(UserOperatorDto userOperatorDto, @MappingTarget UserOperator userOperator);

    //todo AfterMapping
//    @AfterMapping
//    default void linkTariffsList(@MappingTarget UserOperator userOperator){
//        for (Tariff tariff : userOperator.getTariffs() ) {
//            tariff.setUserOperator(userOperator);
//        }
//    }
}
