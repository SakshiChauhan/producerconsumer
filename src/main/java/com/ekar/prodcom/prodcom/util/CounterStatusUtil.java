package com.ekar.prodcom.prodcom.util;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ekar.prodcom.prodcom.constants.ApplicationConstants;
import com.ekar.prodcom.prodcom.entity.CounterTransaction;
import com.ekar.prodcom.prodcom.repository.CounterTransactionRepository;

public class CounterStatusUtil {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void saveTransactionStatus(CounterTransactionRepository counterTransactionRepository) {
        counterTransactionRepository.save(new CounterTransaction(ApplicationConstants.counter, new Date()));
        logger.info("Timestamp Data persisted to data base");
    }

}
