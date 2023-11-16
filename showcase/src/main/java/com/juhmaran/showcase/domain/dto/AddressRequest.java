package com.juhmaran.showcase.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    @JsonProperty(value = "number")
    private String number;

    @JsonProperty(value = "zip_code")
    private String zipCode;

    @JsonProperty(value = "street")
    private String street;

}
