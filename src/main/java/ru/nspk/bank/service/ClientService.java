package ru.nspk.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nspk.bank.exception.BankException;
import ru.nspk.bank.exception.ClientExistsException;
import ru.nspk.bank.model.Account;
import ru.nspk.bank.model.Client;
import ru.nspk.bank.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    private BankService bankService;
    private AccountService accountService;


    public void add(Client client) {
        if (!bankService.existById(client.getBankId())) {
            throw new BankException("Unknown bank id");
        }
        if (clientRepository.existsByName(client.getName())) {
            throw new ClientExistsException("Client name must be unique");
        }
        clientRepository.save(client);
    }

    public Client findByName(String name) {
        return clientRepository
                .findFirstByName(name)
                .orElseThrow(() -> new BankException("Unknown client"));
    }

    public Iterable<Client> findLikeName(String name) {
        return clientRepository.findByNameContains(name);
    }

    public List<Account> getAccounts(String name) {
        return findByName(name)
                .getAccounts();
    }

    public void addAccount(String name) {
        Client client = findByName(name);
        accountService.addFor(client);
    }

    public void delete(String name) {
        clientRepository.deleteByName(name);
    }


    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Autowired
    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
