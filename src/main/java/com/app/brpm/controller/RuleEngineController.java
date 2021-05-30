package com.app.brpm.controller;

import com.app.brpm.exception.InvalidRequestException;
import com.app.brpm.model.Order;
import com.app.brpm.service.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${server.baseUrl}")
public class RuleEngineController {

    @Autowired
    private RulesService rulesService;

    @RequestMapping(method = RequestMethod.POST, value = "/rules/payments/outcome", produces = "application/json")
    public ResponseEntity<?> fireRules(@RequestBody Order orderDetails) {
        try {
            rulesService.firePaymentsRules(orderDetails);
            return new ResponseEntity<>(orderDetails, HttpStatus.OK);
        } catch (InvalidRequestException e) {
            return new ResponseEntity<>("Invalid Request :" + e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
