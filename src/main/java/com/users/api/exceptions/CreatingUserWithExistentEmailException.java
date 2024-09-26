package com.users.api.exceptions;

public class CreatingUserWithExistentEmailException extends RuntimeException  {

    public CreatingUserWithExistentEmailException() {
        super();
    }

    public CreatingUserWithExistentEmailException(String message) {
        super(message);
    }

    public CreatingUserWithExistentEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreatingUserWithExistentEmailException(Throwable cause) {
        super(cause);
    }
}
