package com.ekar.prodcom.prodcom.service;

import com.ekar.prodcom.prodcom.constants.ApplicationConstants;
import com.ekar.prodcom.prodcom.dto.CreateThreadReqDto;
import com.ekar.prodcom.prodcom.dto.ResetCounterReq;
import com.ekar.prodcom.prodcom.entity.CounterTransaction;
import com.ekar.prodcom.prodcom.entity.RequestEntity;
import com.ekar.prodcom.prodcom.repository.CounterTransactionRepository;
import com.ekar.prodcom.prodcom.repository.RequestEntityRepository;
import com.ekar.prodcom.prodcom.util.ConsumerThread;
import com.ekar.prodcom.prodcom.util.ProducerThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerConsumerService {

    @Autowired
    private RequestEntityRepository requestEntityRepository;

    @Autowired
    private CounterTransactionRepository counterTransactionRepository;

    public void updateThread(CreateThreadReqDto reqDto) {

        requestEntityRepository.save(new RequestEntity( reqDto.getProducerCount(), reqDto.getConsumerCount()));

        //Creating Producer and Consumer Thread
        for(int i=0; i < reqDto.getProducerCount(); i++){
            Thread prodThread = new Thread(new ProducerThread(counterTransactionRepository));
            prodThread.start();
        }

        for(int i=0;i<reqDto.getConsumerCount();i++){
            Thread consThread = new Thread(new ConsumerThread(counterTransactionRepository));
            consThread.start();
        }

    }

    public void resetCounter(ResetCounterReq resetCounter) {
        ApplicationConstants.counter = resetCounter.getResetValue();
    }
}
