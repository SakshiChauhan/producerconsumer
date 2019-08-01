package com.ekar.prodcom.prodcom.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="REQUEST")
public class RequestEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID", unique=true, nullable=false)
    private long id;

    @Column(name="PRODUCER_COUNT")
    private Integer producerCount;

    @Column(name="CONSUMER_COUNT")
    private Integer consumerCount;

    public RequestEntity() {
    }

    public RequestEntity(Integer producerCount, Integer consumerCount) {
        this.producerCount = producerCount;
        this.consumerCount = consumerCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
