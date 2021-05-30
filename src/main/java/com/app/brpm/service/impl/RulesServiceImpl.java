package com.app.brpm.service.impl;

import com.app.brpm.exception.InvalidRequestException;
import com.app.brpm.model.Order;
import com.app.brpm.model.ProductDetails;
import com.app.brpm.service.RulesService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RulesServiceImpl implements RulesService {

    @Autowired
    private KieContainer kieContainer;

    @Override
    public void firePaymentsRules(Order order) throws InvalidRequestException {
        // TODO: fire rule and get output
        try {
            KieSession kieSession = kieContainer.newKieSession();
            for (ProductDetails productDetails : order.getProductDetails()) {
                kieSession.setGlobal("productDetails", productDetails);
                kieSession.insert(productDetails);
                kieSession.fireAllRules();
            }
            kieSession.dispose();

        }catch(Exception e)
        {
            e.printStackTrace();
            throw new InvalidRequestException("Error in processing rules..");
        }
    }
}
