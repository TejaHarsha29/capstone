package com.capstone.loanapp.repository;

import com.capstone.loanapp.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions,Long> {


}
