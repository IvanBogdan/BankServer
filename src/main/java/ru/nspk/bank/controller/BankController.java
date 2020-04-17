package ru.nspk.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nspk.bank.model.Bank;
import ru.nspk.bank.model.Client;
import ru.nspk.bank.service.BankService;

import java.util.List;

@RestController
@RequestMapping("banks")
public class BankController {

    private BankService bankService;


    @PostMapping
    public void addBank(@RequestBody Bank bank) {
        bankService.addBank(bank);
    }

    @GetMapping
    public Iterable<Bank> getBanks() {
        return bankService.getBanks();
    }

    @GetMapping(value = "/{id}/clients")
    public List<Client> getClients(@PathVariable("id") Integer bankId) {
        return bankService.getClients(bankId);
    }


    @Autowired
    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }
}
