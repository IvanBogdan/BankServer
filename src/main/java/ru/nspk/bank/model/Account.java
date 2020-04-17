package ru.nspk.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.nspk.bank.exception.NotEnoughFundsException;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id", updatable = false)
    private Client client;

    @JsonProperty(value = "account_number")
    @Column(name = "account_number")
    private String accountNumber;

    private double balance;


    public Account() {
    }

    public Account(Client client, String accountNumber) {
        this.client = client;
        this.accountNumber = accountNumber;
    }


    public void withdraw(double amount) {
        if (balance < amount) {
            throw new NotEnoughFundsException(id, balance, amount);
        }
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
