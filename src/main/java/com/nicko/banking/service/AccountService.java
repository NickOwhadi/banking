package com.nicko.banking.service;

import com.nicko.banking.entity.Account;
import com.nicko.banking.enums.AccountType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface AccountService {

    Account createNewAccount(BigDecimal balance, Date crationDate, AccountType accountType, Long userId);

    List<Account> listAllAccount();

}
