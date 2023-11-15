package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.data.model.Admin;
import org.example.data.model.Role;
import org.example.data.repo.AdminRepo;
import org.example.data.repo.EmployeeRepo;
import org.example.dto.request.LoginAdminRequest;
import org.example.dto.request.RegisterAdminRequest;
import org.example.dto.request.SetRoleRequest;
import org.example.dto.response.AdminResponse;
import org.example.dto.response.EmployeeResponse;
import org.example.dto.response.SalaryResponse;
import org.example.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AdminServices implements AdminService{
    private final AdminRepo adminRepo;
    private final EmployeeRepo employeeRepo;
    @Override
    public void register(RegisterAdminRequest request) {
        Admin admin= new Admin();
        admin.setEmail(request.getEmail());
        admin.setPassword(request.getPassword());
        admin.setLastName(request.getLastName());
        admin.setLastName(request.getLastName());
        adminRepo.save(admin);
    }

    @Override
    public AdminResponse login(LoginAdminRequest request) {
        Admin admin =adminRepo.findByEmailAndPassword(request.getEmail(),request.getPassword())
                .orElseThrow(()-> new UserNotFoundException("User not found"));
         return  AdminResponse.builder()
                .addresses(admin.getAddress())
                .role(admin.getRole())
                .firstName(admin.getFirstName())
                .email(admin.getEmail())
                .build();
    }

    @Override
    public EmployeeResponse setCeoRole(SetRoleRequest request) {
        var employee =employeeRepo.findByEmail(request.getEmail())
                .orElseThrow(()-> new UserNotFoundException("Employee not found"));
        Set<Role> roles = new HashSet<>();
        roles.add(Role.CEO);
        employee.setRole(roles);
        return EmployeeResponse.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .addresses(employee.getAddress())
                .role(employee.getRole())
                .build();
    }

    @Override
    public EmployeeResponse setManagerRole(SetRoleRequest request) {
        var employee =employeeRepo.findByEmail(request.getEmail())
                .orElseThrow(()-> new UserNotFoundException("Employee not found"));
        Set<Role> roles = new HashSet<>();
        roles.add(Role.MANAGER);
        employee.setRole(roles);
        return EmployeeResponse.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .addresses(employee.getAddress())
                .role(employee.getRole())
                .build();
    }

    @Override
    public EmployeeResponse setCleanerRole(SetRoleRequest request) {
        var employee =employeeRepo.findByEmail(request.getEmail())
                .orElseThrow(()-> new UserNotFoundException("Employee not found"));
        Set<Role> roles = new HashSet<>();
        roles.add(Role.CLEANER);
        employee.setRole(roles);
        return EmployeeResponse.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .addresses(employee.getAddress())
                .role(employee.getRole())
                .build();
    }

    @Override
    public EmployeeResponse setSalesPersonRole(SetRoleRequest request) {
        var employee =employeeRepo.findByEmail(request.getEmail())
                .orElseThrow(()-> new UserNotFoundException("Employee not found"));
        Set<Role> roles = new HashSet<>();
        roles.add(Role.SALESPERSON);
        employee.setRole(roles);
        return EmployeeResponse.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .addresses(employee.getAddress())
                .role(employee.getRole())
                .build();
    }

    @Override
    public SalaryResponse setSalary(String email, BigDecimal amount) {
        var employee =employeeRepo.findByEmail(email)
                .orElseThrow(()-> new UserNotFoundException("Employee not found"));
        employee.setSalary(amount);
        return SalaryResponse.builder()
                .salary(employee.getSalary())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .build();
    }


}
