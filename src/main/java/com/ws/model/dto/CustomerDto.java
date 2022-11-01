package com.ws.model.dto;

import lombok.Data;


@Data
public class CustomerDto {

    private String id;
    private String name;
    private String lastName;
    private ProductDto product;
}
