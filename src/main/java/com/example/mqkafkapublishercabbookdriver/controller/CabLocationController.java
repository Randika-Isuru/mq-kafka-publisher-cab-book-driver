package com.example.mqkafkapublishercabbookdriver.controller;

import com.example.mqkafkapublishercabbookdriver.service.CabLocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/location")
public class CabLocationController {

    private final CabLocationService cabLocationService;

    public CabLocationController(CabLocationService cabLocationService) {
        this.cabLocationService = cabLocationService;
    }

    @PutMapping
    public ResponseEntity updateLocation(){

        int range = 100;

        try {
            while (range > 0){
                cabLocationService.updateLocation(Math.random() + " , " + Math.random());
                Thread.sleep(1000);
                range--;
            }
        } catch (InterruptedException ie){
            System.out.println("Error : " + ie.getMessage());
        } catch (Exception ex){
            System.out.println("Exception : " + ex.getMessage());
        }

        return new ResponseEntity<>(Map.of("message", "location updated"), HttpStatus.OK);
    }
}
