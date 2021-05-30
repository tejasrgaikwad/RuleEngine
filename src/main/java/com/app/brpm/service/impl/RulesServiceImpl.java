package com.app.brpm.service.impl;

import com.app.brpm.exception.InvalidRequestException;
import com.app.brpm.model.Order;
import com.app.brpm.service.RulesService;
import org.springframework.stereotype.Service;

@Service
public class RulesServiceImpl implements RulesService {

    @Override
    public void firePaymentsRules(Order order) throws InvalidRequestException {
        // TODO: fire rule and get output
    }
}
