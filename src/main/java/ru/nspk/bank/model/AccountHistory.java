package ru.nspk.bank.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AccountHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "account_id", updatable = false)
    private Account account;

    @Enumerated(EnumType.STRING)
    private AccountOperation operation;

//    @Temporal(TemporalType.TIMESTAMP)
//    private LocalDateTime time;

    @Column(name = "balance_before")
    private double balanceBefore;

    @Column(name = "balance_after")
    private double balanceAfter;

    @ManyToOne
    @JoinColumn(name = "transfer_from_id", updatable = false)
    private Account transferFrom;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public AccountOperation getOperation() {
        return operation;
    }

    public void setOperation(AccountOperation operation) {
        this.operation = operation;
    }

//    public LocalDateTime getTime() {
//        return time;
//    }
//
//    public void setTime(LocalDateTime time) {
//        this.time = time;
//    }

    public double getBalanceBefore() {
        return balanceBefore;
    }

    public void setBalanceBefore(double balanceBefore) {
        this.balanceBefore = balanceBefore;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    public void setBalanceAfter(double balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    public Account getTransferFrom() {
        return transferFrom;
    }

    public void setTransferFrom(Account transferFrom) {
        this.transferFrom = transferFrom;
    }
}
