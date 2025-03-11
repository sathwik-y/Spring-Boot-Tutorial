package com.springdemo.spring_boot_tutorial.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.spring_boot_tutorial.entities.Department;
import com.springdemo.spring_boot_tutorial.error.*;
import com.springdemo.spring_boot_tutorial.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {

        @Autowired
        private DepartmentService departmentService;

        @PostMapping("/departments")
        public Department saveDepartment(@Valid @RequestBody Department department) {
            return departmentService.saveDepartment(department);
        }   

        @GetMapping("/departments")
        public List<Department> fetchDepartmentList() {
            return departmentService.fetchDepartmentList();
        }

        @GetMapping("/departments/{id}")
        public Department fDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
            return departmentService.fetchDepartmentById(departmentId);
        }

        @DeleteMapping("/departments/{id}")
        public String deletDepartmentById(@PathVariable("id") Long departmentId) {
            departmentService.deleteDepartmentById(departmentId);
            return "Deleted Successfully";
        }

        @DeleteMapping("/departments")
        public String deleteAllDepartments() {
            departmentService.deleteAllDepartments();
            return "Deleted All Departments Successfully";
        }

        @PutMapping("/departments/{id}")
        public Department updatedepDepartment(@PathVariable("id") Long departmentId,
                                              @RequestBody Department department) {
            return departmentService.updateDepartment(departmentId, department);
}
        @GetMapping("/departments/name/{name}") 
        public Department getDepartmetbyName(@PathVariable("name") String departmentName) throws NameNotFoundException {
            return departmentService.fetchDepartmentByName(departmentName);
        }
}