package com.stephanie.Springboot.tutorial.controller;

import com.stephanie.Springboot.tutorial.entity.Department;
import com.stephanie.Springboot.tutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // org.slf4j.Logger => slf4j comes with spring boot
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    // @RequestBody annotation makes sure that the json is converted to Department class obj
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long DepartmentId){
        LOGGER.info("Inside fetchDepartmentById of DepartmentController");
        return departmentService.fetchDepartmentById(DepartmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        LOGGER.info("Inside deleteDepartmentById of DepartmentController");
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department){
        LOGGER.info("Inside updateDepartmentById of DepartmentController");
        return departmentService.updateDepartmentById(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Inside getDepartmentByName of DepartmentController");
        return departmentService.getDepartmentByName(departmentName);
    }

}
