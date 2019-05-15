package github.areebmalik1989.core.domain.exception;

import github.areebmalik1989.core.domain.exception.DomainException;

public class NotFoundException extends DomainException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String messageFormat, Object... args) {
        super(String.format(messageFormat, args));
    }
}
