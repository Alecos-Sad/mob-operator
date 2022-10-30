package by.sadovnick.moboperator.dao.repository;

import by.sadovnick.moboperator.dao.entity.UserOperator;
import org.springframework.stereotype.Repository;

/**
 * Repository for working with the user operator entity in the database.
 * @see MainRepository
 * @see UserOperator
 */
@Repository
public interface UserOperatorRepository extends MainRepository<UserOperator>{
}
