package com.example.departmentService.controller;

import com.example.departmentService.entity.Department;
import com.example.departmentService.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public Department saveDepartment(@RequestBody Department department){
        if(department!=null) {
            log.info("saving department: " + department.getDepartmentName());
            return departmentService.saveDepartment(department);
        }
        return null;
    }

    @GetMapping("/{departmentId}")
    public Department findDepartment(@PathVariable("departmentId") Long departmentId){
        log.info("find department: " + departmentId);
        return departmentService.findDepartment(departmentId);

    }


}
