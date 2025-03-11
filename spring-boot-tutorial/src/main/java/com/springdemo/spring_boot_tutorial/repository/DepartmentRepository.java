package com.springdemo.spring_boot_tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdemo.spring_boot_tutorial.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
        public Department findByDepartmentName(String departmentName);
        public Department findByDepartmentNameIgnoreCase(String departmentName);
}
