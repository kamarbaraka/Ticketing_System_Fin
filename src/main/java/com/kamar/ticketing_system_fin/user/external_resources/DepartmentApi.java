package com.kamar.ticketing_system_fin.user.external_resources;

import com.kamar.ticketing_system_fin.department.entity.Department;

import java.util.List;

/**
 * the api to get departments.
 * @author kamar baraka.*/

public interface DepartmentApi {

    Department getDepartmentByName(String name);
    List<Department> getAllDepartments();
}
