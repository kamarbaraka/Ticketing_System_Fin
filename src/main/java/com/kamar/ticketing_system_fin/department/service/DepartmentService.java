package com.kamar.ticketing_system_fin.department.service;

import com.kamar.ticketing_system_fin.department.entity.Department;

import java.util.List;

/**
 * the department service.
 * @author kamar baraka.*/

public interface DepartmentService {

    Department createDepartment(Department department);
    List<Department> getAllDepartments();

    Department getDepartmentByName(String departmentName);
}
