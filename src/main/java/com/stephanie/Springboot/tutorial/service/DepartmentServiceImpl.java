package com.stephanie.Springboot.tutorial.service;

import com.stephanie.Springboot.tutorial.entity.Department;
import com.stephanie.Springboot.tutorial.error.DepartmentNotFoundException;
import com.stephanie.Springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
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
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent())
            throw new DepartmentNotFoundException("Department does not exist");

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department){
        Department department_DB = departmentRepository.getById(departmentId);

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            department_DB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            department_DB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            department_DB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(department_DB);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findFirstByDepartmentNameIgnoreCase(departmentName);
    }
}
