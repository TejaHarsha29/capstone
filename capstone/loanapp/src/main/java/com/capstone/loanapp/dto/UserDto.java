package com.capstone.loanapp.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private long id;

    private String name;

    private String email;
    private String password;
    private String location;
    private long loan_amount;
    private long loan_amount_used;
}
