package francesca.pascalau.data.api;

import francesca.pascalau.data.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * This interface contain two queries that will be used in the business module.
 * For the first query it is needed an additional annotation to highlight the fact that it is a DML operation.
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    @Modifying
    @Query(value = "UPDATE Account SET value = :value WHERE name = :name")
    public void updateAmount(@Param("name") String name, @Param("value") double value);

    @Query(value = "FROM Account WHERE name = :name")
    public Account findByName(@Param("name") String name);
}
