package ru.nspk.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotEnoughFundsException extends BankException {

    private int id;
    private double balance;
    private double amount;


    public NotEnoughFundsException(int id, double balance, double amount) {
        this.id = id;
        this.balance = balance;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    @Override
    public String getMessage() {
        return String.format("Not Enough Funds.%nAccountId: % 10d%nBalance: % 10.2f%nAmount: % 10.2f%n",
                id,
                balance,
                amount);
    }
}
