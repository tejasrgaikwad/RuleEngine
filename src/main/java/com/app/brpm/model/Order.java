package com.app.brpm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private ServiceId serviceId;
    private List<ProductDetails> productDetails = new ArrayList<>();

    public ServiceId getServiceId() {
        return serviceId;
    }

    public void setServiceId(ServiceId serviceId) {
        this.serviceId = serviceId;
    }

    public List<ProductDetails> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetails> productDetails) {
        this.productDetails = productDetails;
    }

}
