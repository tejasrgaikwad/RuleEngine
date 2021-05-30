package com.app.brpm.service;

import com.app.brpm.exception.InvalidRequestException;
import com.app.brpm.model.Order;

public interface RulesService {
    public void firePaymentsRules(Order order) throws InvalidRequestException;
}
