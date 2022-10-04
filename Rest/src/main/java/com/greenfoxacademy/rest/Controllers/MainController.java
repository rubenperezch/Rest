package com.greenfoxacademy.rest.Controllers;

import com.greenfoxacademy.rest.DTOs.ArrDTO;
import com.greenfoxacademy.rest.DTOs.SithDTO;
import com.greenfoxacademy.rest.Services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }


    @PostMapping("/arrays")
    public ResponseEntity<Object> returnArray(@RequestBody (required = false) ArrDTO arrDTO) {

        return ResponseEntity.ok(mainService.arrayHandler(arrDTO));
    }

    @PostMapping("/sith")
    public ResponseEntity<Object> returnSith(@RequestBody (required = false) SithDTO sithDTO) {
        return ResponseEntity.ok(mainService.yodaReply(sithDTO));
    }
}
