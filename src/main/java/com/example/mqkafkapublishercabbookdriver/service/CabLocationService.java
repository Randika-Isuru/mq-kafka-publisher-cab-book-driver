package com.example.mqkafkapublishercabbookdriver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.example.mqkafkapublishercabbookdriver.constant.AppConstant.CAB_LOCATION;

@Service
public class CabLocationService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public boolean updateLocation(String location){
        kafkaTemplate.send(CAB_LOCATION, location);
        return true;
    }
}
