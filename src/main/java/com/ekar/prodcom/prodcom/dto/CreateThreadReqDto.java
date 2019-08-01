package com.ekar.prodcom.prodcom.dto;

public class CreateThreadReqDto {
    private Integer producerCount;
    private Integer consumerCount;

    public Integer getProducerCount() {
        return producerCount;
    }

    public void setProducerCount(Integer producerCount) {
        this.producerCount = producerCount;
    }

    public Integer getConsumerCount() {
        return consumerCount;
    }

    public void setConsumerCount(Integer consumerCount) {
        this.consumerCount = consumerCount;
    }
}
