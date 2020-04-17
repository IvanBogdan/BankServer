package ru.nspk.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nspk.bank.exception.BankException;
import ru.nspk.bank.model.Account;
import ru.nspk.bank.model.Client;
import ru.nspk.bank.repository.AccountRepository;

import java.util.UUID;

@Service
public class AccountService {

    private AccountRepository accountRepository;


    @Transactional
    public void transfer(String accountNumber, String toAccountNumber, double operationAmount) {
        withdraw(accountNumber, operationAmount);
        deposit(toAccountNumber, operationAmount);
    }

    @Transactional
    public void withdraw(String accountNumber, double operationAmount) {
        Account account = findByAccountNumber(accountNumber);
        account.withdraw(operationAmount);
        accountRepository.save(account);
    }

    @Transactional
    public void deposit(String accountNumber, double operationAmount) {
        Account account = findByAccountNumber(accountNumber);
        account.deposit(operationAmount);
        accountRepository.save(account);
    }

    private Account findByAccountNumber(String accountNumber) {
        return accountRepository
                .findFirstByAccountNumber(accountNumber)
                .orElseThrow(() -> new BankException("Unknown account number"));
    }

    public void addFor(Client client) {
        accountRepository.save(
                new Account(
                        client,
                        UUID.randomUUID().toString()
                ));
    }

    public void delete(String accountNumber) {
        accountRepository.deleteByAccountNumber(accountNumber);
    }


    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
