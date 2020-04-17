package ru.nspk.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nspk.bank.exception.BankException;
import ru.nspk.bank.model.Bank;
import ru.nspk.bank.model.Client;
import ru.nspk.bank.repository.BankRepository;

import java.util.List;

@Service
public class BankService {

    private BankRepository bankRepository;

    public void addBank(Bank bank) {
        bankRepository.save(bank);
    }

    public Iterable<Bank> getBanks() {
        return bankRepository.findAll();
    }

    public List<Client> getClients(Integer bankId) {
        return bankRepository
                .findById(bankId)
                .orElseThrow(() ->new BankException("Unknown bank id"))
                .getClients();
    }

    public boolean existById(Integer bankId) {
        return bankId != null && bankRepository.existsById(bankId);
    }


    @Autowired
    public void setBankRepository(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }
}
