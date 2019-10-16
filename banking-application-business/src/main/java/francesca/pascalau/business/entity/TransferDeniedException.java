package francesca.pascalau.business.entity;

public class TransferDeniedException extends RuntimeException {

    public TransferDeniedException(String errorMessage) {
        super(errorMessage);
    }
}
