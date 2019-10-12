package francesca.pascalau.data.api;

import francesca.pascalau.data.entity.Account;
import francesca.pascalau.data.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BankRepository extends JpaRepository<Bank, UUID> {

    @Query(value = "FROM Bank WHERE name = :name")
    public Bank findByName(@Param("name") String name);
}
