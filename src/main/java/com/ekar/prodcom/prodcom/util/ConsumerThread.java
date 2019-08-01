package com.ekar.prodcom.prodcom.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ekar.prodcom.prodcom.constants.ApplicationConstants;

public class ConsumerThread implements Runnable {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void run() {
		while (ApplicationConstants.counter != 100 && ApplicationConstants.counter != 0) {
			ApplicationConstants.counter--;
			logger.info("Consumer " + Thread.currentThread().getName() + " changes counter to : "
					+ ApplicationConstants.counter);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				logger.error("Interrupted Exception in consumer thread : ", e);
			}

		}
	}

}
