package com.ws.model.dto;

import lombok.Data;

@Data
public class CustomerRequest {

    private String id;
    private String name;
    private String lastName;
    private ProductRequest product;
}
