package org.example.service;

import org.example.data.repo.EmployeeRepo;
import org.example.dto.request.LoginEmployeeRequest;
import org.example.dto.request.RegisterAdminRequest;
import org.example.dto.request.RegisterEmployeeRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServicesTest {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Test
    public void registerTest(){
        RegisterEmployeeRequest request = new RegisterEmployeeRequest();
        request.setLastName("john");
        request.setFirstName("seun");
        request.setEmail("johnseun@gmail.com");
        request.setPassword("12345");
        employeeService.register(request);
        assertThat(employeeRepo.count(),is(1L));
    }
    @Test
    public void loginTest(){
        LoginEmployeeRequest request= new LoginEmployeeRequest();
        request.setEmail("johnseun@gmail.com");
        request.setPassword("12345");
        var employee= employeeService.login(request);
        assertThat(employee.getFirstName(), is("seun"));
    }


}