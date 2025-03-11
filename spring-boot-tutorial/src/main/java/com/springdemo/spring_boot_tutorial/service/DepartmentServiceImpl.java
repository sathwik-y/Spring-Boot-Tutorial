package com.springdemo.spring_boot_tutorial.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.springdemo.spring_boot_tutorial.entities.Department;
import com.springdemo.spring_boot_tutorial.error.DepartmentNotFoundException;
import com.springdemo.spring_boot_tutorial.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    @Cacheable("departmentCache")
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department Not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public void deleteAllDepartments() {
        departmentRepository.deleteAll();
    }

    @Override
    @CachePut(value = "departmentCache", key="#departmentId")
    public Department updateDepartment(Long departmentId, Department department) {
            Department depDB = departmentRepository.findById(departmentId).get();
            if(Objects.nonNull(department.getDepartmentName())&& 
            !"".equalsIgnoreCase(department.getDepartmentName())) {
                depDB.setDepartmentName(department.getDepartmentName());
            }
            if(Objects.nonNull(department.getDepartmentCode())&& 
            !"".equalsIgnoreCase(department.getDepartmentCode())) {
                depDB.setDepartmentCode(department.getDepartmentCode());
            }
            if(Objects.nonNull(department.getDepartmentAddress())&& 
            !"".equalsIgnoreCase(department.getDepartmentAddress())) {
                depDB.setDepartmentAddress(department.getDepartmentAddress());
            }
            return departmentRepository.save(depDB);
        }

    @Override
    public Department fetchDepartmentByName(String departmentName){
        // Optional<Department> department = Optional.ofNullable(departmentRepository.findByDepartmentNameIgnoreCase(departmentName));
        // if(!department.isPresent()) {
        //     throw new NameNotFoundException("Department Name Not Registered lil nigga");
        // }
        // return department.get();
        return departmentRepository.findByDepartmentName(departmentName);
    }
    
    
}
