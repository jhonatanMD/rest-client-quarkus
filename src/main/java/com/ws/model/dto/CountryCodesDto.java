package com.ws.model.dto;

import lombok.Data;

@Data
public class CountryCodesDto {
    public String tld;
    public String iso3;
    public String iso2;
    public String fips;
    public int isoN;
}
