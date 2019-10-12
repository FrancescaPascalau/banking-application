package francesca.pascalau.data.api;

import francesca.pascalau.data.entity.Bank;
import francesca.pascalau.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    @Query(value = "FROM Customer WHERE name = :name")
    public Customer findByName(@Param("name") String name);
}
