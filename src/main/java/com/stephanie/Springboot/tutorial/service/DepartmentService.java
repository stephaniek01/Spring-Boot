package com.stephanie.Springboot.tutorial.service;

import com.stephanie.Springboot.tutorial.entity.Department;
import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long id);

    void deleteDepartmentById(Long id);

    Department updateDepartmentById(Long id, Department department);

    Department getDepartmentByName(String departmentName);
}
