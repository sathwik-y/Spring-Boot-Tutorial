package com.springdemo.spring_boot_tutorial.service;

import java.util.List;

import com.springdemo.spring_boot_tutorial.entities.Department;
import com.springdemo.spring_boot_tutorial.error.DepartmentNotFoundException;

public interface  DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public void deleteAllDepartments();

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
    
}
