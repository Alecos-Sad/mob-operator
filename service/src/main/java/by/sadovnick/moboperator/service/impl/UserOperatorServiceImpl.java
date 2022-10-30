package by.sadovnick.moboperator.service.impl;

import by.sadovnick.moboperator.dao.entity.Tariff;
import by.sadovnick.moboperator.dao.entity.UserOperator;
import by.sadovnick.moboperator.dao.repository.TariffRepository;
import by.sadovnick.moboperator.dao.repository.UserOperatorRepository;
import by.sadovnick.moboperator.dto.UserOperatorDto;
import by.sadovnick.moboperator.mapper.UserOperatorMapper;
import by.sadovnick.moboperator.service.UserOperatorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Implementation of UserOperatorService
 *
 * @see UserOperatorService
 * @see UserOperatorRepository
 * @see TariffRepository
 * @see RestTemplate
 * @see UserOperatorMapper
 */
@AllArgsConstructor
@Service
public class UserOperatorServiceImpl implements UserOperatorService {

    private final UserOperatorRepository userOperatorRepository;
    private final TariffRepository tariffRepository;
    private final UserOperatorMapper userOperatorMapper;
    private final RestTemplate restTemplate;

    /**
     * Save dto in database
     *
     * @param userOperatorDto dto
     * @return dto
     */
    @Override
    public UserOperatorDto save(UserOperatorDto userOperatorDto) {
        userOperatorRepository.save(userOperatorMapper.userOperatorDtoToUserOperator(userOperatorDto));
        return userOperatorDto;
    }

    /**
     * Finding user operator by id in database
     *
     * @param id user operator id
     * @return user operator
     */
    @Override
    public Optional<UserOperator> findById(Long id) {
        if (isExistById(id)){
            userOperatorRepository.findById(id);
        } else {
            throw new EntityNotFoundException();
        }
        return userOperatorRepository.findById(id);
    }

    /**
     * Adding funds to the balance
     *
     * @param id    id of user operator
     * @param summa amount of funds
     */
    @Override
    public void replenishTheBalanceById(Long id, Double summa) {
        if (isExistById(id)){
            UserOperator userOperator = userOperatorRepository.findById(id).get();
            userOperator.setBalance(userOperator.getBalance() + summa);
            userOperatorRepository.save(userOperator);
        } else {
            throw new EntityNotFoundException();
        }
    }

    /**
     * Finding all user operators from database
     *
     * @return list of user operators
     */
    @Override
    public Iterable<UserOperator> findAll() {
        return userOperatorRepository.findAll();
    }

    /**
     * Delete user operator by id from database
     *
     * @param id user operator id
     */
    @Override
    public void deleteById(Long id) {
        if (isExistById(id)){
            userOperatorRepository.findById(id);
        } else {
            throw new EntityNotFoundException();
        }
        userOperatorRepository.deleteById(id);
    }

    /**
     * Delete all user operators from database
     */
    @Override
    public void deleteAll() {
        userOperatorRepository.deleteAll();
    }

    /**
     * Сhecks if the user operator with this id is in the database
     * @param id user operator id
     * @return boolean
     */
    public boolean isExistById(Long id) {
        return userOperatorRepository.existsById(id);
    }

    /**
     * Adding tariff to user operator
     *
     * @param userOperatorId id of user operator
     * @param tariffId       id of tariff
     */
    @Override
    public void addTariffByIdToUserOperator(Long userOperatorId, Long tariffId) {
        if (isExistById(userOperatorId)){
            UserOperator userOperator = userOperatorRepository.findById(userOperatorId).get();
            Optional<Tariff> tariffById = tariffRepository.findById(tariffId);
            List<Tariff> tariffs = userOperator.getTariffs();
            tariffs.add(tariffById.get());
            userOperator.setTariffs(tariffs);
            userOperatorRepository.save(userOperator);
        } else {
            throw new EntityNotFoundException();
        }
    }

    //todo localhost:9090

    /**
     * Getting status from external microservice
     *
     * @param status status request
     * @return request from microservice
     */
    @Override
    public String getStatus(String status) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        String url = "http://localhost:9090/number/getStatus/";

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("status", "{status}")
                .encode()
                .toUriString();

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("status", status);

        HttpEntity<String> response = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                String.class,
                uriVariables
        );
        return response.getBody();
    }
}
