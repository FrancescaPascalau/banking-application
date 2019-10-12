package francesca.pascalau.business.entity;

public class TransferDeniedException extends Exception {

    public TransferDeniedException(String errorMessage) {
        super(errorMessage);
    }
}
