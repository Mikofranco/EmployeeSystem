package org.example.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Setter
@Getter
@Builder
public class SalaryResponse {
    private String email;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
}
