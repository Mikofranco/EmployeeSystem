package org.example.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.data.model.Address;
import org.example.data.model.Role;

import java.util.Set;

@Setter
@Getter
@Builder
public class EmployeeResponse {
    private String email;
    private String firstName;
    private String lastName;
    private Set<Address> addresses;
    private Set<Role> role;
}
