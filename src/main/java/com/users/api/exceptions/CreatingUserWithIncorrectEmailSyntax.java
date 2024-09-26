package com.users.api.exceptions;

public class CreatingUserWithIncorrectEmailSyntax extends RuntimeException {

    public CreatingUserWithIncorrectEmailSyntax(String message) {
        super(message);
    }
}
