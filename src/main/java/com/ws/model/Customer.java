package com.ws.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.json.bind.annotation.JsonbProperty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {


    public String id;
    private String name;
    @JsonbProperty("last_name")
    private String lastName;
    private Product product;

}
