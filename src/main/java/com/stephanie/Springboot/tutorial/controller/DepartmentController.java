package com.stephanie.Springboot.tutorial.controller;

import com.stephanie.Springboot.tutorial.entity.Department;
import com.stephanie.Springboot.tutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    // @RequestBody annotation makes sure that the json is converted to Department class obj
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long DepartmentId){
        return departmentService.fetchDepartmentById(DepartmentId);
    }

}
