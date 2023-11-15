package org.example.service;

import org.example.dto.request.LoginAdminRequest;
import org.example.dto.request.LoginEmployeeRequest;
import org.example.dto.request.RegisterAdminRequest;
import org.example.dto.request.RegisterEmployeeRequest;
import org.example.dto.response.AdminResponse;
import org.example.dto.response.EmployeeResponse;

public interface EmployeeService {
    void register(RegisterEmployeeRequest request);
    EmployeeResponse login(LoginEmployeeRequest request);

}
