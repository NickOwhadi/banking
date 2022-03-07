package com.nicko.banking.service;

import com.nicko.banking.entity.Account;
import com.nicko.banking.entity.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TransactionService {

    Transaction makeTransfer(BigDecimal amount, Date creationDate,
                             Account sender, Account receiver,
                             String message);

    List<Transaction> findAll();
}
