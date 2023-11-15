package org.example.service;

import org.example.data.model.Role;
import org.example.data.repo.AdminRepo;
import org.example.dto.request.RegisterAdminRequest;
import org.example.dto.request.SetRoleRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdminServicesTest {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminRepo adminRepo;
    @Test
    public void registerTest(){
        RegisterAdminRequest request=new RegisterAdminRequest();
        request.setEmail("miko@gmail.com");
        request.setPassword("12345");
        request.setFirstName("mic");
        request.setLastName("ayomide");
        adminService.register(request);
        assertThat(adminRepo.count(),is(1L));
    }
    @Test
    public void addRoleTest(){
        SetRoleRequest request = new SetRoleRequest();
        request.setEmail("johnseun@gmail.com");
        adminService.setManagerRole(request);
        var employee =adminService.setCeoRole(request);
        assertTrue(employee.getRole().contains(Role.MANAGER));

    }

}