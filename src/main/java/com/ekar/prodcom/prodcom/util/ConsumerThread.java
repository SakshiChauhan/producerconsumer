package com.ekar.prodcom.prodcom.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ekar.prodcom.prodcom.constants.ApplicationConstants;
import com.ekar.prodcom.prodcom.repository.CounterTransactionRepository;

public class ConsumerThread extends CounterStatusUtil implements Runnable  {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private CounterTransactionRepository counterTransactionRepository;

    public ConsumerThread(CounterTransactionRepository counterTransactionRepository) {
        this.counterTransactionRepository = counterTransactionRepository;
    }

    @Override
    public void run() {
        if(ApplicationConstants.counter>0){
            ApplicationConstants.counter--;
            logger.info("Consumer changes counter to : " + ApplicationConstants.counter);
            if(ApplicationConstants.counter==0){
                saveTransactionStatus(counterTransactionRepository);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error("Interrupted Exception in consumer thread : ",e);
            }

        }
    }

}
