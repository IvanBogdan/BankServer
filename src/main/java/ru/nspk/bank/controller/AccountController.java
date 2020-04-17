package ru.nspk.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nspk.bank.service.AccountService;

@RestController
@RequestMapping("accounts")
public class AccountController {

    private AccountService accountService;

    @PutMapping(value = "{accountNumber}/withdraw/{operationAmount}")
    public void withdraw(@PathVariable("accountNumber") String accountNumber,
                         @PathVariable("operationAmount") double operationAmount) {
        accountService.withdraw(accountNumber, operationAmount);
    }

    @PutMapping(value = "{accountNumber}/transfer/{toAccountNumber}/{operationAmount}")
    public void transfer(@PathVariable("accountNumber") String accountNumber,
                         @PathVariable("toAccountNumber") String toAccountNumber,
                         @PathVariable("operationAmount") double operationAmount) {
        accountService.transfer(accountNumber, toAccountNumber, operationAmount);
    }

    @PutMapping(value = "{accountNumber}/deposit/{operationAmount}")
    public void deposit(@PathVariable("accountNumber") String accountNumber,
                        @PathVariable("operationAmount") double operationAmount) {
        accountService.deposit(accountNumber, operationAmount);
    }

    @DeleteMapping(value = "{accountNumber}")
    public void delete(@PathVariable("accountNumber") String accountNumber) {
        accountService.delete(accountNumber);
    }


    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
