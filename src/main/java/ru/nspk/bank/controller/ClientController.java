package ru.nspk.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nspk.bank.model.Account;
import ru.nspk.bank.model.Client;
import ru.nspk.bank.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private ClientService clientService;


    @PostMapping
    public void add(@RequestBody Client client) {
        clientService.add(client);
    }

    @GetMapping(value = "search/byName/{name}")
    public Client findByName(@PathVariable("name") String name) {
        return clientService.findByName(name);
    }

    @GetMapping(value = "search/likeName/{name}")
    public Iterable<Client> findLikeName(@PathVariable("name") String name) {
        return clientService.findLikeName(name);
    }

    @GetMapping(value = "{name}/accounts")
    public List<Account> getAccounts(@PathVariable("name") String name) {
        return clientService.getAccounts(name);
    }

    @PostMapping(value = "{name}/account")
    public void addAccount(@PathVariable("name") String name) {
        clientService.addAccount(name);
    }

    @DeleteMapping(value = "{name}")
    public void delete(@PathVariable("name") String name) {
        clientService.delete(name);
    }


    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
}
