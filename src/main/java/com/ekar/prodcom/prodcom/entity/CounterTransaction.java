package com.ekar.prodcom.prodcom.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="COUNTER_TRANSACTION")
public class CounterTransaction implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID", unique=true, nullable=false)
    private long id;

    @Column(name="COUNTER")
    private Integer counter;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="TIMESTAMP")
    private Date timeStamp;

    public CounterTransaction() {
    }

    public CounterTransaction(Integer counter, Date timeStamp) {
        this.counter = counter;
        this.timeStamp = timeStamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
