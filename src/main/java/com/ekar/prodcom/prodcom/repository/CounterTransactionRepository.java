package com.ekar.prodcom.prodcom.repository;

import com.ekar.prodcom.prodcom.entity.CounterTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterTransactionRepository extends JpaRepository<CounterTransaction,Long> {
}
