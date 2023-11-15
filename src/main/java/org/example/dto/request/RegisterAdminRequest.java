package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterAdminRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
