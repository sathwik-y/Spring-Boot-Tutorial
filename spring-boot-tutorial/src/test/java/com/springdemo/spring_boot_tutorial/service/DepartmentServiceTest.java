package com.springdemo.spring_boot_tutorial.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springdemo.spring_boot_tutorial.entities.Department;
import com.springdemo.spring_boot_tutorial.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
        .departmentName("IT")
        .departmentAddress("Here")
        .departmentCode("065")
        .departmentId(1L)
        .build();

        Mockito.when(departmentRepository.findByDepartmentName( "IT")).thenReturn(department);
    }

    
    @Test
    @DisplayName("Get Data based on valid deaprtment  name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentname = "IT";
        Department  found = departmentService.fetchDepartmentByName(departmentname);
        assertEquals(departmentname,found.getDepartmentName());
    }
}