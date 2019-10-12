package francesca.pascalau.business.service.api;

import francesca.pascalau.business.entity.TransferBusiness;
import francesca.pascalau.business.entity.TransferDeniedException;

public interface TransferService {

    void transfer(TransferBusiness transferBusiness) throws TransferDeniedException;
}
