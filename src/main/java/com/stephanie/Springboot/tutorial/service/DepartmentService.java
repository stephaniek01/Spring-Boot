package com.stephanie.Springboot.tutorial.service;

import com.stephanie.Springboot.tutorial.entity.Department;
import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long id);
}
