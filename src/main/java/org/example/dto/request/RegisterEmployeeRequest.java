package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterEmployeeRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
