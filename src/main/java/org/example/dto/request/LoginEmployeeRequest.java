package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginEmployeeRequest {
    private String email;
    private String password;
}
