package by.sadovnick.moboperator.dao.repository;

import by.sadovnick.moboperator.dao.entity.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository for working with the client entity in the database.
 * @see MainRepository
 * @see Client
 */
@Repository
public interface ClientRepository extends MainRepository<Client> {
    /**
     * Finding the count of records of type Client
     * @return count of client
     */
    @Query(value = "SELECT COUNT(*) FROM client", nativeQuery = true)
    int findCountOfClientList();
}
