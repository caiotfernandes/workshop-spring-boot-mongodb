package com.caiotfernandes.workshopmongo.services.exception;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 782027939101588070L;

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
