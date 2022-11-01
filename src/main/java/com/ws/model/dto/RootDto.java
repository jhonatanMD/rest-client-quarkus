package com.ws.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RootDto {
    @JsonProperty("StatusMsg")
    public String statusMsg;
    @JsonProperty("Results")
    public ResultsDto results;
    @JsonProperty("StatusCode")
    public int statusCode;
}
