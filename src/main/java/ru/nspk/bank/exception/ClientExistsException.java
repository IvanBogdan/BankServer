package ru.nspk.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ClientExistsException extends BankException {

    public ClientExistsException() {
    }

    public ClientExistsException(String message) {
        super(message);
    }
}
