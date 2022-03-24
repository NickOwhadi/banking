package com.nicko.banking;

import com.nicko.banking.model.Account;
import com.nicko.banking.enums.AccountType;
import com.nicko.banking.service.AccountService;
import com.nicko.banking.service.TransactionService;
import com.nicko.banking.service.impl.AccountServiceImpl;
import com.nicko.banking.service.impl.TransactionServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class BankingApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(BankingApplication.class, args);
		AccountService accountService = applicationContext.getBean(AccountServiceImpl.class);
		TransactionService transactionService = applicationContext.getBean(TransactionServiceImpl.class);

		Account receiver = accountService.createNewAccount( BigDecimal.TEN, new Date(), AccountType.CHECKINGS, 1L);
		Account sender =  accountService.createNewAccount(new BigDecimal(70), new Date(), AccountType.SAVINGS, 1L);

		accountService.listAllAccount().forEach(System.out::println);

		transactionService.makeTransfer(BigDecimal.TEN, new Date(), sender, receiver, "transfer no:1");

		System.out.println(transactionService.findAll().get(0));
		accountService.listAllAccount().forEach(System.out::println);

		transactionService.makeTransfer(new BigDecimal(25), new Date(), sender, receiver, "transfer no:2");

		System.out.println(transactionService.findAll().get(1));
		accountService.listAllAccount().forEach(System.out::println);
	}

}

