package ru.nspk.bank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nspk.bank.model.AccountHistory;

@Repository
public interface HistoryRepository extends CrudRepository<AccountHistory, Integer> {
}
