package github.areebmalik1989.core.domain.exception;

public class NotSavedException extends DomainException {

    public NotSavedException(String message) {
        super(message);
    }

    public NotSavedException(String messageFormat, Object... args) {
        super(String.format(messageFormat, args));
    }
}
