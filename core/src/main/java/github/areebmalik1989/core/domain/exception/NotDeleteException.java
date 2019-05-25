package github.areebmalik1989.core.domain.exception;

public class NotDeleteException extends DomainException {

    public NotDeleteException(String message) {
        super(message);
    }

    public NotDeleteException(String messageFormat, Object... args) {
        super(String.format(messageFormat, args));
    }
}
