package com.capstone.loanapp.service;

import com.capstone.loanapp.dto.TransactionsDto;

import java.util.List;

public interface TransactionService {

    public TransactionsDto saveTransaction(long userId, TransactionsDto transactionsDto);

    public List<TransactionsDto> getAllTransactions(long userId);
}
