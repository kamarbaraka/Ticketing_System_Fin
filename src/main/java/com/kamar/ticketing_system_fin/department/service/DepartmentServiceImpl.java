package com.kamar.ticketing_system_fin.department.service;

import com.kamar.ticketing_system_fin.department.data.ResourceNotFound;
import com.kamar.ticketing_system_fin.department.entity.Department;
import com.kamar.ticketing_system_fin.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * implementation of the department service.
 * @author kamar baraka.*/

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {

        /*persist the department and*/
        /*return the persisted department*/
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {

        /*get all departments*/
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentByName(String departmentName) {

        /*get department by id and return*/
        return departmentRepository.findById(departmentName).get();
    }
}
