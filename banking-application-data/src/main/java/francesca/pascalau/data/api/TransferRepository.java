package francesca.pascalau.data.api;

import francesca.pascalau.data.entity.Transfer;
import francesca.pascalau.data.entity.TransferType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, UUID> {

    public List<Transfer> findByTransferType(TransferType transferType);
}
