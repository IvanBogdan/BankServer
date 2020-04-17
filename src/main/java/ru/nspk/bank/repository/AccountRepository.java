package ru.nspk.bank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.nspk.bank.model.Account;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
    Optional<Account> findFirstByAccountNumber(String accountNumber);
    @Transactional
    void deleteByAccountNumber(String accountNumber);
}
