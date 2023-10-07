package com.kamar.ticketing_system_fin.department.controller;

import com.kamar.ticketing_system_fin.department.entity.Department;
import com.kamar.ticketing_system_fin.department.service.DepartmentService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * the department controller.
 * @author kamar baraka.*/

@RestController
@OpenAPI31
@OpenAPIDefinition(tags = {
        @Tag(name = "Department Api", description = "the department api.")
})
@RequestMapping(value = {"/api/departments"})
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    /**
     * create a department.
     * @param department the {@link Department} object to persist.
     * @return {@link ResponseEntity<Department>} response containing the department.*/
    @PostMapping
    @Operation(tags = {"create department"}, summary = "create a department", description = "post a department")
    public ResponseEntity<Department> postADepartment(@RequestBody Department department){

        /*persist the department*/
        Department persitedDepartment = departmentService.createDepartment(department);
        /*return the department*/
        return ResponseEntity.status(201).body(persitedDepartment);
    }

    /**
     * get a list of all departments.
     * @return a {@link List<Department>} response containing all departments*/
    @GetMapping
    @Operation(tags = {"get all departments"}, description = "get a list of all the departments")
    public ResponseEntity<List<Department>> getAllDepartments(){

        /*get a list of all departments*/
        List<Department> allDepartments = departmentService.getAllDepartments();
        /*return the list of departments*/
        return ResponseEntity.ok(allDepartments);
    }

    /**
     * get a department by name.
     * @param name the name of the department.
     * @return the {@link Department}*/
    @GetMapping(value = {"{name}"})
    @Operation(tags = {"Get a Department"}, summary = "get a department by name", description = "get a department by name")
    public ResponseEntity<Department> getDepartmentByName(@PathVariable("name") String name){

        /*get department by name*/
        Department department = departmentService.getDepartmentByName(name);
        /*return the department*/
        return ResponseEntity.ok(department);
    }
}
