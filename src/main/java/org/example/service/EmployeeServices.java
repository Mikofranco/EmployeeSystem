package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.data.model.Employee;
import org.example.data.repo.EmployeeRepo;
import org.example.dto.request.LoginAdminRequest;
import org.example.dto.request.LoginEmployeeRequest;
import org.example.dto.request.RegisterAdminRequest;
import org.example.dto.request.RegisterEmployeeRequest;
import org.example.dto.response.AdminResponse;
import org.example.dto.response.EmployeeResponse;
import org.example.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeeServices implements EmployeeService{
    private  final EmployeeRepo employeeRepo;
    @Override
    public void register(RegisterEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setEmail(request.getEmail());
        employee.setLastName(request.getLastName());
        employee.setFirstName(request.getFirstName());
        employee.setPassword(request.getPassword());
        employeeRepo.save(employee);
    }

    @Override
    public EmployeeResponse login(LoginEmployeeRequest request) {
        var employee =employeeRepo.findByEmailAndPassword(request.getEmail(), request.getPassword())
                .orElseThrow(()->new UserNotFoundException("User not found"));
        return EmployeeResponse.builder()
                .email(employee.getEmail())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .role(employee.getRole())
                .addresses(employee.getAddress())
                .build();
    }
}
