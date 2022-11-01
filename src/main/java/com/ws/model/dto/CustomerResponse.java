package com.ws.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CustomerResponse {

    private String id;
    private String name;
    private String lastName;
    private String product;
    private BigDecimal price;
}
