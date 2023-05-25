package com.capstone.loanapp.controller;


import com.capstone.loanapp.dto.TransactionsDto;
import com.capstone.loanapp.model.Transactions;
import com.capstone.loanapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/{userid}/transactions")
    public ResponseEntity<TransactionsDto> saveTransaction(@PathVariable(name = "userid") long userid,
                                                           @RequestBody TransactionsDto transactionsDto)
    {
        return new ResponseEntity<>(transactionService.saveTransaction(userid,transactionsDto), HttpStatus.CREATED);
    }
}
