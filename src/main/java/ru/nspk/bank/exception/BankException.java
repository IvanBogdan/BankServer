package ru.nspk.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BankException extends RuntimeException {

    public BankException() {
    }

    public BankException(String message) {
        super(message);
    }
}
