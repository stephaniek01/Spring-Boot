package com.stephanie.Springboot.tutorial.repository;

import com.stephanie.Springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentName(String departmentName);
    Department findFirstByDepartmentName(String departmentName);
    Department findFirstByDepartmentNameIgnoreCase(String departmentName);
}
