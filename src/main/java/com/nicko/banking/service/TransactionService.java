package com.nicko.banking.service;

import com.nicko.banking.model.Account;
import com.nicko.banking.model.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TransactionService {

    Transaction makeTransfer(BigDecimal amount, Date creationDate,
                             Account sender, Account receiver,
                             String message);

    List<Transaction> findAll();
}
