package com.ekar.prodcom.prodcom.resource;

import com.ekar.prodcom.prodcom.dto.CreateThreadReqDto;
import com.ekar.prodcom.prodcom.dto.ResetCounterReq;
import com.ekar.prodcom.prodcom.service.ProducerConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerConsumerController {

    @Autowired
    private ProducerConsumerService producerConsumerService;

    @PostMapping("/createThread")
    public ResponseEntity createThread(@RequestBody CreateThreadReqDto reqDto){
        producerConsumerService.updateThread(reqDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/resetCounter")
    public ResponseEntity resetCounter(@RequestBody ResetCounterReq counter){
        producerConsumerService.resetCounter(counter);
        return new ResponseEntity(HttpStatus.OK);
    }


}
