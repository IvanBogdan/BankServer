package ru.nspk.bank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.nspk.bank.model.Client;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
    boolean existsByName(String name);
    Optional<Client> findFirstByName(String name);
    Iterable<Client> findByNameContains(String name);
    @Transactional
    void deleteByName(String name);
}
