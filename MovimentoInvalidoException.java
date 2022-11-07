package peoo_trabalho;

public class MovimentoInvalidoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    MovimentoInvalidoException(String message) {
        super(message);
    }
}