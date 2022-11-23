package com.example.departmentService.service;

import com.example.departmentService.entity.Department;
import com.example.departmentService.repository.DepartmentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService  {

    @Autowired
    private DepartmentRepo departmentRepo;

    public Department saveDepartment(Department department) {
        log.info("Service method to save department");
        return departmentRepo.save(department);
    }

    public Department findDepartment(Long departmentId) {
        log.info("Service method to find department");
        return departmentRepo.findById(departmentId).orElse(null);
    }
}
