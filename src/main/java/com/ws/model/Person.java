package com.ws.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person  {

    private Long id;
    @NotEmpty(message = "name no puede ser vacio o nulo")
    private String name;
    @NotEmpty(message = "age no puede ser vacio o nulo")
    private String age;
    @NotEmpty(message = "birthdate no puede ser vacio o nulo")
    private String birthdate;
}
