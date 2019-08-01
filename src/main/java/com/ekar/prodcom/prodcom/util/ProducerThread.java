package com.ekar.prodcom.prodcom.util;

import com.ekar.prodcom.prodcom.constants.ApplicationConstants;
import com.ekar.prodcom.prodcom.repository.CounterTransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProducerThread extends CounterStatusUtil implements Runnable{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private CounterTransactionRepository counterTransactionRepository;

    public ProducerThread(CounterTransactionRepository counterTransactionRepository) {
        this.counterTransactionRepository = counterTransactionRepository;
    }

    @Override
    public void run() {
        if(ApplicationConstants.counter<100){
            ApplicationConstants.counter++;
            logger.info("Producer changes counter to : " + ApplicationConstants.counter);
            if(ApplicationConstants.counter==100){
                saveTransactionStatus(counterTransactionRepository);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error("Interrupted Exception in producer thread : ",e);
            }
        }
    }
}
