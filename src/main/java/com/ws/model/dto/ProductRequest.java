package com.ws.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    private String code;
    private String name;
    private BigDecimal price;
}
