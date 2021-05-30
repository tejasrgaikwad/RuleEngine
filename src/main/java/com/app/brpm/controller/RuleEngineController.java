package com.app.brpm.controller;

import com.app.brpm.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${server.baseUrl}")
public class RuleEngineController {

    @RequestMapping(method = RequestMethod.POST, value = "/rules/payments/outcome", produces = "application/json")
    public ResponseEntity<?> fireRules(@RequestBody Order orderDetails) {
        return new ResponseEntity<>("Invalid Request " , HttpStatus.BAD_REQUEST);
    }
}
