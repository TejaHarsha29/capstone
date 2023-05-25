package com.capstone.loanapp.serviceImpl;

import com.capstone.loanapp.dto.TransactionsDto;
import com.capstone.loanapp.exception.UserNotFound;
import com.capstone.loanapp.model.Transactions;
import com.capstone.loanapp.model.Users;
import com.capstone.loanapp.repository.TransactionRepository;
import com.capstone.loanapp.repository.UserRepository;
import com.capstone.loanapp.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public TransactionsDto saveTransaction(long userId, TransactionsDto transactionsDto) {
        Users user = userRepository.findById(userId).orElseThrow(()->new UserNotFound(String.format("UserID %d not found",userId)));
        Transactions transactions = modelMapper.map(transactionsDto,Transactions.class);
        transactions.setUsers(user);
        transactionRepository.save(transactions);
        return modelMapper.map(transactions,TransactionsDto.class);
    }

    @Override
    public List<TransactionsDto> getAllTransactions(long userId) {
        return null;
    }
}
