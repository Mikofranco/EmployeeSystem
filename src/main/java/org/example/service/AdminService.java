package org.example.service;

import org.example.dto.request.LoginAdminRequest;
import org.example.dto.request.RegisterAdminRequest;
import org.example.dto.request.SetRoleRequest;
import org.example.dto.response.AdminResponse;
import org.example.dto.response.EmployeeResponse;
import org.example.dto.response.SalaryResponse;

import java.math.BigDecimal;

public interface AdminService {
    void register(RegisterAdminRequest request);
    AdminResponse login(LoginAdminRequest request);
    EmployeeResponse setCeoRole(SetRoleRequest request);
    EmployeeResponse setManagerRole(SetRoleRequest request);
    EmployeeResponse setCleanerRole(SetRoleRequest request);
    EmployeeResponse setSalesPersonRole(SetRoleRequest request);
    SalaryResponse setSalary(String email, BigDecimal amount);


}
