package com.ekar.prodcom.prodcom.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekar.prodcom.prodcom.constants.ApplicationConstants;
import com.ekar.prodcom.prodcom.dto.CreateThreadReqDto;
import com.ekar.prodcom.prodcom.dto.ResetCounterReq;
import com.ekar.prodcom.prodcom.entity.CounterTransaction;
import com.ekar.prodcom.prodcom.entity.RequestEntity;
import com.ekar.prodcom.prodcom.repository.CounterTransactionRepository;
import com.ekar.prodcom.prodcom.repository.RequestEntityRepository;
import com.ekar.prodcom.prodcom.util.ConsumerThread;
import com.ekar.prodcom.prodcom.util.ProducerThread;

@Service
public class ProducerConsumerService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RequestEntityRepository requestEntityRepository;

	@Autowired
	private CounterTransactionRepository counterTransactionRepository;

	public void updateThread(CreateThreadReqDto reqDto) {

		requestEntityRepository.save(new RequestEntity(reqDto.getProducerCount(), reqDto.getConsumerCount()));

		// Creating Producer and Consumer Thread
		for (int i = 0; i < reqDto.getProducerCount(); i++) {
			Thread prodThread = new Thread(new ProducerThread());
			prodThread.start();
		}

		for (int i = 0; i < reqDto.getConsumerCount(); i++) {
			Thread consThread = new Thread(new ConsumerThread());
			consThread.start();
		}

		if (ApplicationConstants.counter == 0 || ApplicationConstants.counter == 100) {
			counterTransactionRepository.save(new CounterTransaction(ApplicationConstants.counter, new Date()));
			logger.info("Timestamp Data persisted to data base");
		}

	}

	public void resetCounter(ResetCounterReq resetCounter) {
		ApplicationConstants.counter = resetCounter.getResetValue();
	}
}
