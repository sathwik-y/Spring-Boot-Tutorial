package com.springdemo.spring_boot_tutorial.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.springdemo.spring_boot_tutorial.entities.Department;

@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Mech")
                .departmentAddress("Delhi")
                .departmentCode("OO1")
                .build();
        entityManager.persist(department);
    }

    @Test
    public void whenFindbyId_thenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"Mech");
    }
}