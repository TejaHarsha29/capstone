package com.capstone.loanapp.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.service.annotation.GetExchange;

@Getter
@Setter
public class TransactionsDto {
    private long id;
    private String transactionName;
}
